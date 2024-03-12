package com.setu.splitwise.handler;

import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;
import com.setu.splitwise.repository.h2.UserGroupRepository;
import com.setu.splitwise.repository.h2.UserRepository;
import com.setu.splitwise.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;

    public UserEntity createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(UserEntity.builder()
                .userId(UserUtils.generateUserId())
                .name(createUserRequest.getName())
                .email(createUserRequest.getEmail())
                .build());
    }

    public UserEntity getUserInfo(String userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.orElseGet(() -> UserEntity.builder().build());
    }

    public List<String> getUserGroups(String userId) {
        return userGroupRepository.getUserGroupList(userId);
    }
}
