package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.GroupUserBalance;
import com.setu.splitwise.model.UserBalance;
import com.setu.splitwise.model.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, String> {

    @Query(nativeQuery = true, name = "get_all_user_balance_in_group")
    List<UserBalance> getUserBalanceList(String groupId);

    @Query(nativeQuery = true, name = "get_user_balance_in_group")
    List<UserBalance> getUserBalance(String groupId, String userId);

    @Query(nativeQuery = true, name = "get_user_balance_in_all_group")
    List<GroupUserBalance> getUserBalance(String userId);

}
