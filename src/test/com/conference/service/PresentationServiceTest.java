package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Presentation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class PresentationServiceTest {

    @Autowired
    private PresentationService presentationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUsersId() throws Exception {
        List<Presentation> presentationList = presentationService.findByUsersId(Arrays.asList(new Long(1)));
        assertEquals(presentationList.size(), 3);
    }

    @Test
    public void testFindById() throws Exception {
        String presentationName = "Presentation 1";
        Presentation presentation = presentationService.findById(1L);
        assertThat(presentation.getName(), is(presentationName));
    }

    @Test
    public void testSave() throws Exception {
        String testPresentationName = "Test presentation";
        Presentation presentation = new Presentation();
        presentation.setName(testPresentationName);
        presentation.setRoom(roomService.getAllRooms().get(0));
        presentation.setUsers(Arrays.asList(userService.getUserById(1), userService.getUserById(2)));
        Long testPresentationId = presentationService.save(presentation).getId();
        Presentation testPresentation = presentationService.findById(testPresentationId);
        assertThat(testPresentation.getName(), is(testPresentationName));
    }

    @Test
    public void testDelete() throws Exception {
        Presentation presentationBefore = presentationService.findById(1L);
        presentationService.delete(presentationService.findById(1L));
        Presentation presentationAfter = presentationService.findById(1L);
        assertNotNull(presentationBefore);
        assertNull(presentationAfter);
    }

}