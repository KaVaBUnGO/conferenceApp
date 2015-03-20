package com.conference.service;

import com.conference.domain.Presentation;
import org.springframework.data.repository.CrudRepository;

public interface PresentationRepository extends CrudRepository<Presentation, Long>{

}
