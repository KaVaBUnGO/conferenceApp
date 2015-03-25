package com.conference.web.rest;

import com.conference.domain.ScheduleRow;
import com.conference.service.PresentationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ScheduleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private PresentationService presentationService;

    @RequestMapping("/schedule")
    public List<ScheduleRow> getSchedule(){
        return presentationService.getSchedule();
    }
}
