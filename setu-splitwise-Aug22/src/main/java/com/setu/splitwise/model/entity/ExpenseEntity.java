package com.setu.splitwise.model.entity;

import com.setu.splitwise.model.GroupUserBalance;
import com.setu.splitwise.model.UserBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
//@Table(
//        uniqueConstraints = @UniqueConstraint(columnNames = {"transactionId", "userId"}),
//        indexes = @Index(columnList = {"groupId", "userId"})
//)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "get_all_user_balance_in_group",
                query = "SELECT USER_ID as userId, sum(BALANCE) as balance FROM EXPENSE_ENTITY WHERE GROUP_ID like ?1 group by USER_ID",
                resultSetMapping = "user_balance"
        ),
        @NamedNativeQuery(
                name = "get_user_balance_in_group",
                query = "SELECT USER_ID as userId, sum(BALANCE) as balance FROM EXPENSE_ENTITY WHERE GROUP_ID like ?1 and USER_ID like ?2",
                resultSetMapping = "user_balance"
        ),
        @NamedNativeQuery(
                name = "get_user_balance_in_all_group",
                query = "SELECT USER_ID as userId, sum(BALANCE) as balance, GROUP_ID as groupId FROM EXPENSE_ENTITY WHERE USER_ID like ?1 group by GROUP_ID",
                resultSetMapping = "user_groupwise_balance"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "user_balance",
                classes = @ConstructorResult(
                        targetClass = UserBalance.class,
                        columns = {
                                @ColumnResult(name = "userId", type = String.class),
                                @ColumnResult(name = "balance", type = Long.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "user_groupwise_balance",
                classes = @ConstructorResult(
                        targetClass = GroupUserBalance.class,
                        columns = {
                                @ColumnResult(name = "userId", type = String.class),
                                @ColumnResult(name = "balance", type = Long.class),
                                @ColumnResult(name = "groupId", type = String.class)
                        }
                )
        )
})
public class ExpenseEntity {
    @Id
    @GeneratedValue
    private long id;
    private String transactionId;
    private String userId;
    private long paidAmount;
    private long balance;
    private String groupId;
    @CreationTimestamp
    private Date createdTime;

}
