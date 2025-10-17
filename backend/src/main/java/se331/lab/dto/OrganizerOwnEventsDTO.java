package se331.lab.dto;
// import ที่จำเป็น...

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerOwnEventsDTO {
    Long id;
    String category;
    String title;
    // ... fields อื่นๆ ของ Event ที่คุณต้องการโชว์
}