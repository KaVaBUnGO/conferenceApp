package com.conference.repository;

import com.conference.domain.Presentation;
import com.conference.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PresentationRepository extends CrudRepository<Presentation, Long> {

    List<Presentation> findByUsersIn(Collection<User> users);
    List<Presentation> findByUsersIdIn(Collection<Long> id);
}
