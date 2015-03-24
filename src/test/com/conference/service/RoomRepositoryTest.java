package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Room;
import com.conference.service.PresentationRepository;
import com.conference.service.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class RoomRepositoryTest {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    PresentationRepository presentationRepository;

    @Test
    public void findFirstRoom(){
        Room firstRoom = this.roomRepository.findOne(1L);
        assertEquals(firstRoom.getName(), "Red room");
    }

    @Test
    public void crudTest(){
        Room room = new Room();
        room.setName("Test room");
        room.setPresentations(Collections.singleton(presentationRepository.findOne(1L)));
        roomRepository.save(room);
        Room testRoom = roomRepository.findByName("Test room");
        assertEquals(testRoom.getPresentations().iterator().next(), presentationRepository.findOne(1L));
    }

}