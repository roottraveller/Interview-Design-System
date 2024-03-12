package com.example.meeting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    private String title;
    private String description;
    private String date;
    private String createdBy;
    private long startTime;
    private long endTime;
}
