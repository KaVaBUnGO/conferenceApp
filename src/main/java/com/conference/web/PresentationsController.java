package com.conference.web;


import com.conference.domain.CurrentUser;
import com.conference.domain.Presentation;
import com.conference.domain.Room;
import com.conference.service.PresentationRepository;
import com.conference.service.RoomRepository;
import com.conference.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("/presentations")
public class PresentationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PresentationsController.class);

    @Autowired
    private PresentationRepository presentationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Room.class, new RoomEditor());
    }

    @RequestMapping(value = {"/", "/list"})
    @Secured("ROLE_PRESENTER")
    public String getPresentationsPage(Model model) {
        LOGGER.debug("Getting presentations page");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser user = (CurrentUser) authentication.getPrincipal();

        LOGGER.debug("find presentations: " + presentationRepository.findByUsersIdIn(Collections.singleton(user.getId())));

        model.addAttribute("presentation", new Presentation());
        model.addAttribute("userPresentations", presentationRepository.findByUsersIdIn(Collections.singleton(user.getId())));
        model.addAttribute("rooms", roomRepository.findAll());
        return "presentations";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured("ROLE_PRESENTER")
    public String savePresentation(@ModelAttribute("presentation") Presentation presentation, BindingResult bindingResult) {
        LOGGER.debug("Getting save presentation action " + presentation.toString() + " " + presentation.getRoom().toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        presentation.setUsers(Arrays.asList(currentUser.getUser()));
        presentationRepository.save(presentation);
        return "redirect:list";
    }

    @RequestMapping("/get/{presentationId}")
    @Secured("ROLE_PRESENTER")
    public String getPresentation(@PathVariable Long presentationId, Model model){
        LOGGER.debug("Getting presentation by id action");

        Presentation presentation = presentationRepository.findOne(presentationId);
        model.addAttribute("presentation", presentation);
        model.addAttribute("rooms", roomRepository.findAll());
        return "presentationForm";
    }


    private class RoomEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Long id = Long.parseLong(text);
            Room room = roomRepository.findOne(id);
            setValue(room);
        }
    }
}