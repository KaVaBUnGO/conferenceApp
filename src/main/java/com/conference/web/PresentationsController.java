package com.conference.web;


import com.conference.domain.CurrentUser;
import com.conference.domain.Presentation;
import com.conference.domain.Room;
import com.conference.repository.PresentationRepository;
import com.conference.repository.RoomRepository;
import com.conference.repository.UserRepository;
import com.conference.service.PresentationService;
import com.conference.service.RoomService;
import com.conference.service.UserService;
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
    private PresentationService presentationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

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
        model.addAttribute("presentation", new Presentation());
        model.addAttribute("userPresentations", presentationService.findByUsersId(Arrays.asList(user.getId())));
        model.addAttribute("rooms", roomService.getAllRooms());
        return "presentations";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured("ROLE_PRESENTER")
    public String savePresentation(@ModelAttribute("presentation") Presentation presentation, BindingResult bindingResult) {
        LOGGER.debug("Getting save presentation action ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        presentation.setUsers(Arrays.asList(userService.getUserById(currentUser.getId())));
        presentationService.save(presentation);
        return "redirect:list";
    }

    @RequestMapping("/get/{presentationId}")
    @Secured("ROLE_PRESENTER")
    public String getPresentation(@PathVariable Long presentationId, Model model) {
        LOGGER.debug("Getting presentation by id action");
        Presentation presentation = presentationService.findById(presentationId);
        model.addAttribute("presentation", presentation);
        model.addAttribute("rooms", roomService.getAllRooms());
        return "presentationForm";
    }

    @RequestMapping("/delete/{presentationId}")
    @Secured("ROLE_PRESENTER")
    public String deletePresentation(@PathVariable("presentationId") Long presentationId) {
        LOGGER.debug("Delete presentation by id action");
        Presentation p = presentationService.findById(presentationId);
        presentationService.delete(p);
        return "redirect:/presentations/list";
    }


    private class RoomEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Long id = Long.parseLong(text);
            Room room = roomService.getRoomById(id);
            setValue(room);
        }
    }
}
