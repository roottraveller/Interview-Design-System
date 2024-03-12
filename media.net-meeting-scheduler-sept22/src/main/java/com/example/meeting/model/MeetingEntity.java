package com.example.meeting.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@ToString
public class MeetingEntity extends Meeting {
    private long meetingId;
    private List<String> attendee;
    private Map<String, Boolean> acceptanceStatus;
}
