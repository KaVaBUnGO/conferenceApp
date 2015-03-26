package com.conference.web.rest;

import com.conference.domain.ScheduleRow;
import com.conference.service.PresentationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ScheduleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private PresentationService presentationService;

    private static final String PATH_SCHEDULE = "/schedule";

    /**
     * Return a schedule in JSON format.
     * Schedule row contains presentationName, room
     * and authors fields.
     *
     * @return List of scheduleRow objects in JSON
     */
    @RequestMapping(PATH_SCHEDULE)
    public List<ScheduleRow> getSchedule() {
        return presentationService.getSchedule();
    }
}
