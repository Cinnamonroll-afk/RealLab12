package se331.lab.util;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.dto.EventDTO;
import se331.lab.dto.OrganizerDTO;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.dto.ParticipantDTO;
import se331.lab.entity.Participant;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
    ParticipantDTO getParticipantDto(Participant participant);
    List<ParticipantDTO> getParticipantDto(List<Participant> participants);
}