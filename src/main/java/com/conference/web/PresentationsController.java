package com.conference.web;


import com.conference.domain.CurrentUser;
import com.conference.domain.User;
import com.conference.service.PresentationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PresentationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PresentationsController.class);

    @Autowired
    private PresentationRepository presentationRepository;

    @RequestMapping("/presentations")
    public String getPresentationsPage(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser user = (CurrentUser)authentication.getPrincipal();


        LOGGER.debug("Getting presentations page " + user.getId() + " " + user.getUsername()) ;
        return "presentations";
    }
}
