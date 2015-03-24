package com.conference.service;

import com.conference.domain.Presentation;
import com.conference.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    List<Presentation> findByUsersIn(Collection<User> users);

    List<Presentation> findByUsersIdIn(Collection<Long> id);

}
