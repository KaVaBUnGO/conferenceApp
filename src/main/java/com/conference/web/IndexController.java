package com.conference.web;

import com.conference.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RoomService roomService;

    @RequestMapping("/")
    public String getHomePage(Model model){
        LOGGER.debug("Getting home page");
        model.addAttribute("rooms", roomService.getAllRooms());
        return "index";
    }
}
