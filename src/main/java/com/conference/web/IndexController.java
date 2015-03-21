package com.conference.web;

import com.conference.domain.Presentation;
import com.conference.domain.Room;
import com.conference.domain.User;
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
    @Autowired
    private PresentationRepository presentationRepository;

    @RequestMapping("/")
    @ResponseBody
    public String getRooms(){
        StringBuilder ans = new StringBuilder("");
        Iterator<Room> rooms = roomRepository.findAll().iterator();
        while(rooms.hasNext()){
            Room room = rooms.next();
            ans.append(room.getName()).append(" [ ");
            for(Presentation presentation : room.getPresentations()){
                ans.append(presentation.getName()).append(" ( ");
                for(User user : presentation.getUsers()){
                    ans.append(user.getEmail()).append("  ");
                }
                ans.append(" ) ");
            }
            ans.append(" ] \n");
        }
        return ans.toString();
    }
}
