package com.example.meeting.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Slot {
    private long startTime;
    private long endTime;
}
