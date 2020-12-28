package com.denizhal.site.controller;

import com.denizhal.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("user",userService.getUserByUserName(principal.getName()));

        return "user/home";
    }



}
