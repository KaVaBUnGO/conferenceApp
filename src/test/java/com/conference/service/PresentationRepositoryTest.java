package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Presentation;
import com.conference.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class PresentationRepositoryTest {

    @Autowired
    PresentationRepository presentationRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findPresentationByUser() {
        User user = userRepository.findById(1L);
        List<Presentation> presentationList = presentationRepository.findByUsersIn(Collections.singleton(user));
        assertEquals(presentationList.size(), 2);
    }

    @Test
    public void findPresentationByUsersId() {
        List<Presentation> presentationList = presentationRepository.findByUsersIdIn(Collections.singleton(new Long(1L)));
        assertEquals(presentationList.size(), 2);
    }
}