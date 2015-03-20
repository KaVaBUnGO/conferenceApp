package com.conference.web;

import com.conference.service.PresentationRepository;
import com.conference.service.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
public class IndexController {

    @Autowired
    private RoomRepository roomRepository;
    private PresentationRepository presentationRepository;

    @RequestMapping("/")
    @ResponseBody
    public String getRooms(){
        return presentationRepository.findOne(1L).toString();

    }
}
