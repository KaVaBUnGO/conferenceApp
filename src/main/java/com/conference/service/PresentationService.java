package com.conference.service;


import com.conference.domain.Presentation;
import com.conference.domain.ScheduleRow;

import java.util.List;

public interface PresentationService {

    List<Presentation> findByUsersId(List<Long> usersId);
    Presentation findById(Long id);
    Presentation save(Presentation presentation);
    void delete(Presentation presentation);
    List<ScheduleRow> getSchedule();

}
