package com.setu.splitwise.controller;


import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;
import com.setu.splitwise.service.UserService;
import com.setu.splitwise.utils.UserUtils;
import com.setu.splitwise.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/splitwise/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserEntity> createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserUtils.validate(createUserRequest);
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserInfo(@PathVariable("userId") String userId) {
        Utils.validateUserId(userId);
        return ResponseEntity.ok(userService.getUserInfo(userId));
    }

    @GetMapping("/{userId}/groups")
    public ResponseEntity<List<String>> getUserGroups(@PathVariable("userId") String userId) {
        Utils.validateUserId(userId);
        return ResponseEntity.ok(userService.getUserGroups(userId));
    }
}
