package com.cs.tobaccosystem.controller;

import com.cs.tobaccosystem.UserValidator;
import com.cs.tobaccosystem.bean.User;
import com.cs.tobaccosystem.service.SecurityService;
import com.cs.tobaccosystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class WebController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error","Your username and password is invalid.");
        }

        if(logout != null){
            model.addAttribute("message","You have been logged out.");
        }

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String welcome(Principal principal, Model model){
        model.addAttribute("name",principal.getName());
        return "welcome";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,Model model){
        userValidator.validate(user,bindingResult);

        if(bindingResult.hasErrors()){
            List<FieldError> errorList = bindingResult.getFieldErrors();
            errorList.forEach(fieldError -> {
                model.addAttribute(fieldError.getField(),true);
            });
            return "registration";
        }

        userService.save(user);
        securityService.autoLogin(user.getUsername(),user.getPasswordConfirm());

        return "redirect:/welcome";
    }
}
