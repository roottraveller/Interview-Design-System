package com.setu.splitwise.model.entity;

import com.setu.splitwise.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String userId;
    private String name;
    private String email;
    @CreationTimestamp
    private Date createdTime;
    @Builder.Default
    private Currency default_currency = Currency.INR;

}
