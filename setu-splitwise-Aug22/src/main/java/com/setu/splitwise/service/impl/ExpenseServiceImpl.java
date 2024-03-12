package com.setu.splitwise.service.impl;

import com.setu.splitwise.handler.ExpenseHandler;
import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import com.setu.splitwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseHandler expenseHandler;

    @Override
    public boolean addExpense(CreateExpenseRequest createExpenseRequest) {
        return expenseHandler.addExpense(createExpenseRequest);
    }

    @Override
    public GroupSummaryResponse getGroupSummary(String groupId) {
        return expenseHandler.getGroupSummary(groupId);
    }

    @Override
    public UserSummaryResponse getGroupUserSummary(String groupId, String userId) {
        return expenseHandler.getGroupUserSummary(groupId, userId);
    }

    @Override
    public UserSummaryResponse getUserSummary(String userId) {
        return expenseHandler.getUserSummary(userId);
    }
}
