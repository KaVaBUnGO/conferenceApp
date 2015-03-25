package com.conference.service;

import com.conference.domain.Room;
import com.conference.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        LOGGER.debug("Getting all rooms");
        return (List)roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        LOGGER.debug("Getting room={}", id);
        return roomRepository.findOne(id);
    }
}
