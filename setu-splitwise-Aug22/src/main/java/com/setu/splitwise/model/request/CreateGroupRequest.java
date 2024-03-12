package com.setu.splitwise.model.request;

import lombok.Data;

@Data
public class CreateGroupRequest {
    private String name;
    private String type;
    private String createdBy;
}
