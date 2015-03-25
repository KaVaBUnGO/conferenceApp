package com.conference.web;

import com.conference.domain.CurrentUser;
import com.conference.domain.User;
import com.conference.domain.UserCreateForm;
import com.conference.domain.validator.UserCreateFormValidator;
import com.conference.service.EmailService;
import com.conference.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    private EmailService emailService;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String getUserCreatePage(Model model){
        LOGGER.debug("Getting user create form");
        model.addAttribute("form", new UserCreateForm());
        return "userCreate";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "userCreate";
        }
        try {
            User user = userService.create(form);
            CurrentUser currentUser = new CurrentUser(user);
            Authentication auth =
                    new UsernamePasswordAuthenticationToken(currentUser, null, currentUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            emailService.sendMail("kavabungo1@gmail.com", "Hello", "lalalaTest");
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "userCreate";
        }
        return "redirect:/";
    }
}
