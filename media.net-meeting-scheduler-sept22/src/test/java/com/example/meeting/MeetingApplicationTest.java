package com.example.meeting;

import com.example.meeting.model.MeetingEntity;
import com.example.meeting.model.MeetingRequest;
import com.example.meeting.service.MeetingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MeetingApplicationTest {
    @InjectMocks
    private MeetingService meetingService;

//    @Test
    public void test() {
        List<String> users = new ArrayList<>();
        users.add("rishi");
        users.add("ravi");
        users.add("rohith");
        long meetingId = meetingService.createMeeting(MeetingRequest.builder()
                .createdBy("rishi")
                .date("12-sept")
                .description("sample meet")
                .startTime(630)
                .endTime(900)
                .title("test meeting")
                .attendee(users)
                .build());

        List<MeetingEntity> meetingEntities = meetingService.getMeeting("rishi", "12-sept");
        for (MeetingEntity entity : meetingEntities) {
            System.out.println(entity);
        }

//        meetingService.acceptMeeting()


    }

}