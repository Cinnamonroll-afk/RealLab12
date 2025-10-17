package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Event;
import se331.lab.service.EventService;
import se331.lab.util.LabMapper; // เพิ่ม import ของ LabMapper

@Controller
@RequiredArgsConstructor
public class EventController {

    final EventService eventService;

    @GetMapping("events")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                           @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<Event> pageOutput = eventService.getEvents(perPage, page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        // แปลง List<Event> เป็น List<EventDTO> ก่อนส่งกลับ
        return new ResponseEntity<>(LabMapper.INSTANCE.getEventDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEvent(id);
        if (output != null) {
            // แปลง Event เป็น EventDTO ก่อนส่งกลับ
            return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        Event output = eventService.save(event);
        // แปลง Event ที่ถูกบันทึกแล้ว เป็น EventDTO ก่อนส่งกลับ
        return ResponseEntity.ok(LabMapper.INSTANCE.getEventDto(output));
    }
}
