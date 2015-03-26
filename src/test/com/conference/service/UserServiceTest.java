package com.conference.service;

import com.conference.ConferenceApplication;
import com.conference.domain.Role;
import com.conference.domain.User;
import com.conference.domain.UserCreateForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() throws Exception {
        User user = userService.getUserById(1L);
        assertThat(user.getRole(), is(Role.ROLE_LISTENER));
    }

    @Test
    public void testGetUserByName() throws Exception {
        User user = userService.getUserByName("user");
        assertThat(user.getId(), is(1L));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        assertThat(userService.getAllUsers().size(), greaterThan(2));
    }

    @Test
    public void testCreate() throws Exception {
        UserCreateForm userCreateForm = new UserCreateForm();
        userCreateForm.setName("testUser");
        userCreateForm.setEmail("test@mail.com");
        userCreateForm.setPassword("test");
        User testUser = userService.create(userCreateForm);
        assertThat(testUser.getEmail(), is("test@mail.com"));
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setEmail("test@mail.com");
        user.setRole(Role.ROLE_LISTENER);
        userService.save(user);
        User testUser = userService.getUserByName("test");
        assertThat(testUser.getEmail(), is("test@mail.com"));
    }

    @Test
    public void testDelete() throws Exception {
        User user = userService.getUserById(1L);
        assertNotNull(user);
        userService.delete(userService.getUserById(1L));
        assertNull(userService.getUserById(1L));
    }
}