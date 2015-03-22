package com.conference.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConferenceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    @RequestMapping("/conference")
    public String getConferencePage(Model model){
        LOGGER.debug("Getting conference page");
        return "conference";
    }
}
