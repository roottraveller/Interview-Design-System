package com.setu.splitwise.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {
    @Id
    private String groupId;
    private String name;
    private String type;
    private String createdBy;
    @CreationTimestamp
    private Date createdTime;

}
