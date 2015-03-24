package com.conference.service;

import com.conference.domain.Presentation;
import com.conference.domain.ScheduleRow;
import com.conference.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public List<ScheduleRow> getSchedule() {
        List<ScheduleRow> schedule = new ArrayList<ScheduleRow>();
        for(Presentation presentation : presentationRepository.findAll()){
            ArrayList<String> authorsList = new ArrayList<String>();
            for(User user : presentation.getUsers()){
                authorsList.add(user.getName());
            }
            ScheduleRow row = new ScheduleRow(presentation.getName(), presentation.getRoom().getName(), authorsList);
            schedule.add(row);
        }
        return schedule;
    }
}
