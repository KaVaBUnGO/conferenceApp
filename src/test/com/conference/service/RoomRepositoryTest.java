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

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class RoomRepositoryTest {

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void findFirstRoom(){
        Room firstRoom = this.roomRepository.findOne(1L);
        assertEquals(firstRoom.getName(), "Red room");
    }

}