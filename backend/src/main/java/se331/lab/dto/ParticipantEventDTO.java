package se331.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantEventDTO {
    Long id;
    String category;
    String title;
    String location;
    String date;
    String time;
}