package com.setu.splitwise.handler;

import com.setu.splitwise.model.Expanse;
import com.setu.splitwise.model.GroupUserBalance;
import com.setu.splitwise.model.UserBalance;
import com.setu.splitwise.model.entity.ExpenseEntity;
import com.setu.splitwise.model.entity.TransactionEntity;
import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import com.setu.splitwise.repository.h2.ExpenseRepository;
import com.setu.splitwise.repository.h2.TransactionRepository;
import com.setu.splitwise.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Component
public class ExpenseHandler {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    // TODO - enable transaction support
    public boolean addExpense(CreateExpenseRequest createExpenseRequest) {
        String uniqueTransactionId = ExpenseUtils.generateTransactionId();

        long totalAmount = createExpenseRequest.getExpanses().stream().mapToLong(Expanse::getPaidAmount).sum();
        long totalUsers = createExpenseRequest.getExpanses().size();
        long perUserShare = totalAmount / totalUsers;
        for (Expanse expanse : createExpenseRequest.getExpanses()) {
            expenseRepository.save(ExpenseEntity.builder()
                    .transactionId(uniqueTransactionId)
                    .userId(expanse.getUserId())
                    .paidAmount(expanse.getPaidAmount())
                    .balance(expanse.getPaidAmount() - perUserShare)
                    .groupId(createExpenseRequest.getGroupId())
                    .build());
        }
        transactionRepository.save(TransactionEntity.builder()
                .transactionId(uniqueTransactionId)
                .description(createExpenseRequest.getDescription())
                .total(createExpenseRequest.getCost())
                .build());
        return true;
    }

    public GroupSummaryResponse getGroupSummary(String groupId) {
        List<UserBalance> userBalanceList = expenseRepository.getUserBalanceList(groupId);
        return GroupSummaryResponse.builder()
                .total(0) // TODO
                .userBalanceList(userBalanceList)
                .build();
    }

    public UserSummaryResponse getUserSummary(String userId) {
        List<GroupUserBalance> groupUserBalanceList = expenseRepository.getUserBalance(userId);
        return UserSummaryResponse.builder()
                .total(groupUserBalanceList.stream()
                        .mapToLong(GroupUserBalance::getBalance)
                        .sum())
                .groupUserBalanceList(groupUserBalanceList)
                .build();
    }

    public UserSummaryResponse getGroupUserSummary(String groupId, String userId) {
        List<UserBalance> userBalance = expenseRepository.getUserBalance(groupId, userId);
        long balance = CollectionUtils.isEmpty(userBalance) ? 0 : userBalance.get(0).getBalance();
        return UserSummaryResponse.builder()
                .total(0) //TODO
                .groupUserBalanceList(Collections.singletonList(GroupUserBalance.builder()
                        .groupId(groupId)
                        .userId(userId)
                        .balance(balance)
                        .build()))
                .build();
    }
}
