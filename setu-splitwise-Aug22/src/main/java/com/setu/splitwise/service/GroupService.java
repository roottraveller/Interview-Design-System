package com.setu.splitwise.service;

import com.setu.splitwise.model.entity.GroupEntity;
import com.setu.splitwise.model.request.AddUsersToGroupRequest;
import com.setu.splitwise.model.request.CreateGroupRequest;
import com.setu.splitwise.model.request.RemoveUserFromGroupRequest;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    GroupEntity getGroupInfo(String groupId);

    GroupEntity createGroup(CreateGroupRequest createGroupRequest);

    GroupEntity deleteGroup(String groupId);

    boolean addUserToGroup(AddUsersToGroupRequest addUsersToGroupRequest);

    boolean removeUserFromGroup(RemoveUserFromGroupRequest removeUserFromGroupRequest);

}
