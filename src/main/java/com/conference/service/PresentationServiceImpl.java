package com.conference.service;

import com.conference.domain.Presentation;
import com.conference.domain.ScheduleRow;
import com.conference.domain.User;
import com.conference.repository.PresentationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PresentationServiceImpl implements PresentationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PresentationServiceImpl.class);

    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public List<ScheduleRow> getSchedule() {
        LOGGER.debug("Getting schedule");
        List<ScheduleRow> schedule = new ArrayList<ScheduleRow>();
        for (Presentation presentation : presentationRepository.findAll()) {
            ArrayList<String> authorsList = new ArrayList<String>();
            for (User user : presentation.getUsers()) {
                authorsList.add(user.getName());
            }
            ScheduleRow row = new ScheduleRow(presentation.getName(), presentation.getRoom().getName(), authorsList);
            schedule.add(row);
        }
        return schedule;
    }

    @Override
    public List<Presentation> findByUsersId(List<Long> usersId) {
        LOGGER.debug("Getting presentation by usersIdList");
        return presentationRepository.findByUsersIdIn(usersId);
    }

    @Override
    public Presentation findById(Long id) {
        LOGGER.debug("Getting presentation={}\", id");
        return presentationRepository.findOne(id);
    }

    @Override
    public Presentation save(Presentation presentation) {
        LOGGER.debug("Saving presentation={}\", presentation");
        return presentationRepository.save(presentation);
    }

    @Override
    public void delete(Presentation presentation) {
        LOGGER.debug("Deleting presentation={}\", presentation");
        presentationRepository.delete(presentation);
    }
}
