package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {
}
