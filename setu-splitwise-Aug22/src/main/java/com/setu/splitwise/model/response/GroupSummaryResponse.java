package com.setu.splitwise.model.response;

import com.setu.splitwise.model.UserBalance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GroupSummaryResponse {
    private long total;
    private List<UserBalance> userBalanceList;
}
