package com.setu.splitwise.model.response;

import com.setu.splitwise.model.GroupUserBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSummaryResponse {
    private long total;
    private List<GroupUserBalance> groupUserBalanceList;
}
