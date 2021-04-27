package com.denizhal.site.controller;

import com.denizhal.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/fatura")
public class FaturaController {
    private final UserService userService;

    public FaturaController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String main(Model model, Principal principal){
        model.addAttribute("user",userService.getUserByUserName(principal.getName()));
        return "hal/fatura/main";
    }
    //Satış Faturası
    @GetMapping("/{userid}/satis")
    public String satisFaturasi(@PathVariable("userid") Integer userid, Model model){
        return null;
    }




}
