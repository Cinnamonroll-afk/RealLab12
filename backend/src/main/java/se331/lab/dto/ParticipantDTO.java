package se331.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList; // เพิ่ม import
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    Long id;
    String name;
    String telNo;

    // แก้ไขจาก List<EventDTO> เป็น List<ParticipantEventDTO>
    @Builder.Default
    List<ParticipantEventDTO> eventHistory = new ArrayList<>();
}