package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
}
