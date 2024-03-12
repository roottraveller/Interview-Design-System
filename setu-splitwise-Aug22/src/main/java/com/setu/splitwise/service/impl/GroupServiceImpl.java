package com.setu.splitwise.service.impl;

import com.setu.splitwise.handler.GroupHandler;
import com.setu.splitwise.model.entity.GroupEntity;
import com.setu.splitwise.model.request.AddUsersToGroupRequest;
import com.setu.splitwise.model.request.CreateGroupRequest;
import com.setu.splitwise.model.request.RemoveUserFromGroupRequest;
import com.setu.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupHandler groupHandler;

    @Override
    public GroupEntity getGroupInfo(String groupId) {
        return groupHandler.getGroupInfo(groupId);
    }

    @Override
    public GroupEntity createGroup(CreateGroupRequest createGroupRequest) {
        return groupHandler.createGroup(createGroupRequest);
    }

    @Override
    public GroupEntity deleteGroup(String groupId) {
        return groupHandler.deleteGroup(groupId);
    }

    @Override
    public boolean addUserToGroup(AddUsersToGroupRequest addUsersToGroupRequest) {
        return groupHandler.addUserToGroup(addUsersToGroupRequest);
    }

    @Override
    public boolean removeUserFromGroup(RemoveUserFromGroupRequest removeUserFromGroupRequest) {
        return groupHandler.removeUserFromGroup(removeUserFromGroupRequest);
    }
}
