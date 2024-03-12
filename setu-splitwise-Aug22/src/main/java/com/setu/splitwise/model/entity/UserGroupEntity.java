package com.setu.splitwise.model.entity;

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
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "GROUP_ID"})},
//        indexes = {@Index(columnList = {"USER_ID", "GROUP_ID"})})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "get_user_all_groups",
                query = "SELECT distinct GROUP_ID as groupId FROM USER_GROUP_ENTITY WHERE USER_ID like ?1",
                resultSetMapping = "user_all_groups"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "user_all_groups",
                classes = @ConstructorResult(
                        targetClass = String.class,
                        columns = {
                                @ColumnResult(name = "groupId", type = String.class)
                        }
                )
        )
})
public class UserGroupEntity {
    @Id
    @GeneratedValue
    private long id;
    private String userId;
    private String groupId;
    @CreationTimestamp
    private Date createdTime;
}
