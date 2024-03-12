package com.setu.splitwise.service;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    boolean addExpense(CreateExpenseRequest createExpenseRequest);

    GroupSummaryResponse getGroupSummary(String groupId);

    UserSummaryResponse getGroupUserSummary(String groupId, String userId);

    UserSummaryResponse getUserSummary(String userId);
}
