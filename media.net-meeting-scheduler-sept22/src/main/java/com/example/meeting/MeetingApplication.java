package com.example.meeting;

import com.example.meeting.model.MeetingEntity;
import com.example.meeting.model.MeetingRequest;
import com.example.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

//ravi.t@media.net
@SpringBootApplication
public class MeetingApplication {
    @Autowired
    private MeetingService meetingService;

    public static void main(String[] args) {
        SpringApplication.run(MeetingApplication.class, args);
        new MeetingApplication().test();
    }

    public void test() {
//        MeetingService meetingService = new MeetingService();
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
