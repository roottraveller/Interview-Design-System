package com.setu.splitwise.service;


import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    UserEntity createUser(CreateUserRequest createUserRequest);

    UserEntity getUserInfo(String userId);

    List<String> getUserGroups(String userId);

}
