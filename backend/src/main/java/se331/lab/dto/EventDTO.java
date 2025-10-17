package se331.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;

    // ใช้ DTO สำหรับ Organizer เพื่อป้องกันข้อมูลวนลูป
    EventOrganizerDTO organizer;

    // ใช้ DTO สำหรับ Participant เพื่อป้องกันข้อมูลวนลูป
    @Builder.Default
    List<EventParticipantDTO> participants = new ArrayList<>();
}