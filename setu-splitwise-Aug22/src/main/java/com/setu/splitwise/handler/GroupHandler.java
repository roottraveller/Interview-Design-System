package com.setu.splitwise.handler;

import com.setu.splitwise.model.entity.GroupEntity;
import com.setu.splitwise.model.entity.UserGroupEntity;
import com.setu.splitwise.model.request.AddUsersToGroupRequest;
import com.setu.splitwise.model.request.CreateGroupRequest;
import com.setu.splitwise.model.request.RemoveUserFromGroupRequest;
import com.setu.splitwise.repository.h2.GroupRepository;
import com.setu.splitwise.repository.h2.UserGroupRepository;
import com.setu.splitwise.repository.h2.UserRepository;
import com.setu.splitwise.utils.GroupUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class GroupHandler {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserRepository userRepository;

    public GroupEntity getGroupInfo(String groupId) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
        return groupEntity.orElseGet(() -> GroupEntity.builder().build());
    }

    public GroupEntity createGroup(CreateGroupRequest createGroupRequest) {
        if (!userRepository.existsById(createGroupRequest.getCreatedBy())) {
            log.error("user does not exist");
            return GroupEntity.builder().build();
        }
        return groupRepository.save(GroupEntity.builder()
                .groupId(GroupUtils.generateGroupId())
                .name(createGroupRequest.getName())
                .type(createGroupRequest.getType())
                .createdBy(createGroupRequest.getCreatedBy())
                .build());
    }

    public GroupEntity deleteGroup(String groupId) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
        if (groupEntity.isPresent()) {
            groupRepository.deleteById(groupId);
            return groupEntity.get();
        }
        log.error("group does not exist");
        return GroupEntity.builder().build();
    }

    public boolean addUserToGroup(AddUsersToGroupRequest addUsersToGroupRequest) {
        List<UserGroupEntity> userGroupEntityList = new ArrayList<>();
        //TODO:validate both users and group exist
        for (String userId : addUsersToGroupRequest.getUidxList()) {
            userGroupEntityList.add(UserGroupEntity.builder()
                    .groupId(addUsersToGroupRequest.getGroupId())
                    .userId(userId)
                    .build());
        }
        userGroupRepository.saveAll(userGroupEntityList);
        return true;
    }

    public boolean removeUserFromGroup(RemoveUserFromGroupRequest removeUserFromGroupRequest) {
        //TODO
        return false;
    }
}
