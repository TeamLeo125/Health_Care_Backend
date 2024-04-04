package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findRoomByRoomId(String roomId);
}
