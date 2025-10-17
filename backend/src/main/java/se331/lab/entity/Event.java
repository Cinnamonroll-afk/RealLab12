package se331.lab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id; // <-- ย้าย @Id และ @GeneratedValue มาไว้ที่นี่

    private String category;
    private String title;
    private String description;
    private String location;
    private String date;
    private String time;
    private Boolean petAllowed; // <-- เอา @Id ออกจากตรงนี้

    @ManyToOne
    private Organizer organizer;

    @ManyToMany(mappedBy = "eventHistory")
    @Builder.Default
    private List<Participant> participants = new ArrayList<>();
}

