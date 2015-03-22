package com.conference.service;

import com.conference.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}