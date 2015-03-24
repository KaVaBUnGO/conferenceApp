package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Presentation;
import com.conference.domain.User;
import com.conference.service.PresentationRepository;
import com.conference.service.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class PresentationRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PresentationRepositoryTest.class);

    @Autowired
    PresentationRepository presentationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void findPresentationByUser() {
        User user = userRepository.findById(2L);
        List<Presentation> presentationList = presentationRepository.findByUsersIn(Collections.singleton(user));
        assertEquals(presentationList.size(), 2);
    }

    @Test
    public void findPresentationByUsersId() {
        List<Presentation> presentationList = presentationRepository.findByUsersIdIn(Collections.singleton(new Long(1L)));
        assertEquals(presentationList.size(), 2);
    }

    @Test
    public void crudTest() {
        Presentation presentation = new Presentation();
        presentation.setName("Test");
        presentation.setRoom(roomRepository.findByName("Red room"));
        presentation.setUsers(Arrays.asList(userRepository.findById(1L)));
        Presentation p = presentationRepository.saveAndFlush(presentation);
        assertEquals(p.getUsers().iterator().next().getName(), userRepository.findById(1L).getName());
    }
}