package com.conference.web;

import com.conference.service.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping("/")
    public String getHomePage(Model model){
        LOGGER.debug("Getting home page");
        model.addAttribute("rooms", roomRepository.findAll());
        return "index";
    }
}
