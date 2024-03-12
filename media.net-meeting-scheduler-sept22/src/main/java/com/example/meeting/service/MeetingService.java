package com.example.meeting.service;

import com.example.meeting.handler.MeetingHandler;
import com.example.meeting.model.MeetingEntity;
import com.example.meeting.model.MeetingRequest;
import com.example.meeting.model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingHandler meetingHandler;

    public long createMeeting(MeetingRequest meetingRequest) {
        return meetingHandler.createMeeting(meetingRequest);
    }

    public boolean acceptMeeting(String userId, long meetingId){
        return meetingHandler.acceptMeeting(userId, meetingId);
    }

    public List<MeetingEntity> getMeeting(String userId, String date) {
        return meetingHandler.getMeeting(userId, date);
    }

    public Slot getFreeSlot(List<String> userIds, String date, long fromTime, long toTime) {
        return meetingHandler.getFreeSlot(userIds, date, fromTime, toTime);
    }
}
