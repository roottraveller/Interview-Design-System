package com.setu.splitwise.model.request;

import lombok.Data;

@Data
public class RemoveUserFromGroupRequest {
    private String groupId;
    private String userId;
}
