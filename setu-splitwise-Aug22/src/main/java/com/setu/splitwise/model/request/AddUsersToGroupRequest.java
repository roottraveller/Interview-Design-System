package com.setu.splitwise.model.request;

import lombok.Data;

import java.util.List;

@Data
public class AddUsersToGroupRequest {
    private String groupId;
    private List<String> uidxList;
}
