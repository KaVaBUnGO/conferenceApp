package com.conference.service;

import com.conference.domain.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(Long id);
}
