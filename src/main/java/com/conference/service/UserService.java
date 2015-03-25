package com.conference.service;

import com.conference.domain.User;
import com.conference.domain.UserCreateForm;
import java.util.List;

public interface UserService {
    User getUserById(long id);
    User getUserByName(String name);
    List<User> getAllUsers();
    User create(UserCreateForm form);
    User save(User user);
    void delete(User user);
}
