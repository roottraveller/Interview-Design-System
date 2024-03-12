package com.setu.splitwise.model.request;

import com.setu.splitwise.model.Expanse;
import lombok.Data;

import java.util.List;

@Data
public class CreateExpenseRequest {
    private String groupId;
    private long cost;
    private List<Expanse> expanses;
    private String description;
}
