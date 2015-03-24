package com.conference.service;

import com.conference.domain.Role;
import com.conference.domain.User;
import com.conference.domain.UserCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByName(String name) {
        LOGGER.debug("Getting user by name");
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        List<User> users = new ArrayList<User>();
        for(User user : userRepository.findAll()){
            users.add(user);
        }
        return users;
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        user.setRole(Role.ROLE_LISTENER);
        return userRepository.save(user);
    }
}
