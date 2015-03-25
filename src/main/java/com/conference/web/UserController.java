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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String getUserCreatePage(Model model) {
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
//            emailService.sendMail("kavabungo1@gmail.com", "Welcome!", "Thx for registration :)");
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "userCreate";
        }
        return "redirect:/";
    }

    @RequestMapping("/users")
    @Secured("ROLE_ADMIN")
    public String getUsers(Model model) {
        LOGGER.debug("Getting users list");
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        LOGGER.debug("Getting save user action");
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping("/users/get/{userId}")
    @Secured("ROLE_ADMIN")
    public String getUser(@PathVariable("userId") Long userId, Model model) {
        LOGGER.debug("Getting get user action" + userId);
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("password", "invisible");
        return "userForm";
    }

    @RequestMapping("/users/delete/{userId}")
    @Secured("ROLE_ADMIN")
    public String deleteUser(@PathVariable("userId") Long userId) {
        LOGGER.debug("Delete user by id action");
        User user = userService.getUserById(userId);
        userService.delete(user);
        return "redirect:/users";
    }

}
