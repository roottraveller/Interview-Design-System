package com.example.meeting.handler;

import com.example.meeting.model.MeetingEntity;
import com.example.meeting.model.MeetingRequest;
import com.example.meeting.model.Slot;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MeetingHandler {
    // meeting-id
    private static final Map<Long, MeetingEntity> meetingMap = new HashMap<>();
    //user-id, meeting-id
    private static final Map<String, List<Long>> userMeetingMap = new HashMap<>();

    public long createMeeting(MeetingRequest meetingRequest) {
        long meetingId = UUID.randomUUID().getMostSignificantBits();
        MeetingEntity meetingEntity = MeetingEntity.builder()
                .meetingId(meetingId)
                .createdBy(meetingRequest.getCreatedBy())
                .date(meetingRequest.getDate())
                .description(meetingRequest.getDescription())
                .endTime(meetingRequest.getEndTime())
                .startTime(meetingRequest.getStartTime())
                .title(meetingRequest.getTitle())
                .attendee(meetingRequest.getAttendee())
                .build();

        // insert, TODO
        meetingMap.put(meetingId, meetingEntity);
        // created user
        List<Long> meetingList = userMeetingMap.getOrDefault(meetingRequest.getCreatedBy(), new ArrayList<Long>());
        meetingList.add(meetingId);
        userMeetingMap.put(meetingRequest.getCreatedBy(), meetingList);

        // for all the attendee
        for (String user : meetingRequest.getAttendee()) {
            List<Long> meetingList1 = userMeetingMap.getOrDefault(user, new ArrayList<Long>());
            meetingList1.add(meetingId);
            userMeetingMap.put(user, meetingList1);
        }
        return meetingId;
    }

    public boolean acceptMeeting(String userId, long meetingId) {
        MeetingEntity meetingEntity = meetingMap.get(meetingId);
        if (meetingEntity != null && meetingEntity.getAcceptanceStatus() != null
                && meetingEntity.getAcceptanceStatus().containsKey(userId)) {
            meetingEntity.getAcceptanceStatus().put(userId, true);
            return true;
        }
        return false;
    }

    public List<MeetingEntity> getMeeting(String userId, String date) {
        List<MeetingEntity> response = new ArrayList<>();
        List<Long> meetingList = userMeetingMap.get(userId);
        for (long meetingId : meetingList) {
            if (meetingMap.containsKey(meetingId) && meetingMap.get(meetingId).getDate().equalsIgnoreCase(date)) {
                response.add(meetingMap.get(meetingId));
            }
        }
        return response;
    }

    public Slot getFreeSlot(List<String> userIds, String date, long fromTime, long toTime) {
        for (String userId : userIds) {
            userMeetingMap.containsKey(userId);
        }
        return Slot.builder().build();
    }
}
