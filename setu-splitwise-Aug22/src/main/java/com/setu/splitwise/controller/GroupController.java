package com.setu.splitwise.controller;

import com.setu.splitwise.model.entity.GroupEntity;
import com.setu.splitwise.model.request.AddUsersToGroupRequest;
import com.setu.splitwise.model.request.CreateGroupRequest;
import com.setu.splitwise.model.request.RemoveUserFromGroupRequest;
import com.setu.splitwise.service.GroupService;
import com.setu.splitwise.utils.GroupUtils;
import com.setu.splitwise.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/splitwise/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupEntity> createGroup(@RequestBody CreateGroupRequest createGroupRequest) {
        GroupUtils.validate(createGroupRequest);
        return ResponseEntity.ok(groupService.createGroup(createGroupRequest));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupEntity> getGroupInfo(@PathVariable("groupId") String groupId) {
        Utils.validateGroupId(groupId);
        return ResponseEntity.ok(groupService.getGroupInfo(groupId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GroupEntity> deleteGroup(@RequestBody String groupId) {
        Utils.validateGroupId(groupId);
        return ResponseEntity.ok(groupService.deleteGroup(groupId));
//        throw new OperationNotSupportedException();
    }

    @PostMapping("/addusers")
    public ResponseEntity<Boolean> addUserToGroup(@RequestBody AddUsersToGroupRequest addUsersToGroupRequest) {
        GroupUtils.validate(addUsersToGroupRequest);
        return ResponseEntity.ok(groupService.addUserToGroup(addUsersToGroupRequest));
    }

    @PostMapping("/removeuser")
    public ResponseEntity<Boolean> removeUserFromGroup(@RequestBody RemoveUserFromGroupRequest removeUserFromGroupRequest) {
        GroupUtils.validate(removeUserFromGroupRequest);
        return ResponseEntity.ok(groupService.removeUserFromGroup(removeUserFromGroupRequest));
    }


}
