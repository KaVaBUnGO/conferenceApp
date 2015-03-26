package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class RoomServiceTest {

    @Autowired
    RoomService roomService;

    @Test
    public void testFindAllRooms(){
        int count = this.roomService.getAllRooms().size();
        assertEquals(count, 4);
    }

    @Test
    public void testFindRoomById(){
        String roomName = "Red room";
        Room room = roomService.getRoomById(2L);
        assertThat(room.getName(), is(roomName));
    }

}