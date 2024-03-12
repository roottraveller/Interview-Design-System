package com.setu.splitwise.service.impl;

import com.setu.splitwise.handler.UserHandler;
import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;
import com.setu.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserHandler userHandler;

    @Override
    public UserEntity createUser(CreateUserRequest createUserRequest) {
        return userHandler.createUser(createUserRequest);
    }

    @Override
    public UserEntity getUserInfo(String userId) {
        return userHandler.getUserInfo(userId);
    }

    @Override
    public List<String> getUserGroups(String userId) {
        return userHandler.getUserGroups(userId);
    }
}
