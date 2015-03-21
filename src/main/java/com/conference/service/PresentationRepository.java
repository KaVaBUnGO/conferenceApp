package com.conference.service;

import com.conference.domain.Presentation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long>{

}
