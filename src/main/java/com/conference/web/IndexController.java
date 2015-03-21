package com.conference.web;

import com.conference.domain.Room;
import com.conference.service.PresentationRepository;
import com.conference.service.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PresentationRepository presentationRepository;

    @RequestMapping("/")
    public String getRooms(Model model){
        model.addAttribute("rooms", roomRepository.findAll());
        return "index";
    }
}
