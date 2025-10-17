package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se331.lab.entity.Event; // แก้ไข import ให้ถูกต้องตาม path ของคุณ

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> { // เปลี่ยนตรงนี้
    List<Event> findAll();
}