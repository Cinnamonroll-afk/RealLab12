package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // 1. สร้าง Organizers
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

        // 2. สร้าง Events และเชื่อมความสัมพันธ์กับ Organizers
        Event event1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        event1.setOrganizer(org1);
        org1.getOwnEvents().add(event1);

        Event event2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention Hall")
                .date("25th Jan")
                .time("8.00-12.00 am.")
                .petAllowed(false)
                .build());
        event2.setOrganizer(org1);
        org1.getOwnEvents().add(event2);

        Event event3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for festival")
                .location("Ping River")
                .date("15th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        event3.setOrganizer(org2);
        org2.getOwnEvents().add(event3);

        // 3. สร้าง Participants
        Participant p1 = participantRepository.save(Participant.builder().name("John Doe").telNo("081-111-1111").build());
        Participant p2 = participantRepository.save(Participant.builder().name("Jane Smith").telNo("082-222-2222").build());
        Participant p3 = participantRepository.save(Participant.builder().name("Peter Jones").telNo("083-333-3333").build());
        Participant p4 = participantRepository.save(Participant.builder().name("Mary Williams").telNo("084-444-4444").build());
        Participant p5 = participantRepository.save(Participant.builder().name("David Brown").telNo("085-555-5555").build());

        // 4. เชื่อมความสัมพันธ์ระหว่าง Events และ Participants
        // Event ที่ 1 (Midterm Exam)
        event1.getParticipants().add(p1);
        event1.getParticipants().add(p2);
        event1.getParticipants().add(p3);
        p1.getEventHistory().add(event1);
        p2.getEventHistory().add(event1);
        p3.getEventHistory().add(event1);

        // Event ที่ 2 (Commencement Day)
        event2.getParticipants().add(p3);
        event2.getParticipants().add(p4);
        event2.getParticipants().add(p5);
        p3.getEventHistory().add(event2);
        p4.getEventHistory().add(event2);
        p5.getEventHistory().add(event2);

        // Event ที่ 3 (Loy Krathong)
        event3.getParticipants().add(p1);
        event3.getParticipants().add(p4);
        event3.getParticipants().add(p5);
        p1.getEventHistory().add(event3);
        p4.getEventHistory().add(event3);
        p5.getEventHistory().add(event3);
    }
}