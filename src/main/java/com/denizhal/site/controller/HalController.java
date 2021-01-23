package com.denizhal.site.controller;

import com.denizhal.site.model.HalUser;
import com.denizhal.site.service.GenelBilgilerService;
import com.denizhal.site.service.HalUserService;
import com.denizhal.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hal")
public class HalController {
    private final UserService userService;
    private final HalUserService halUserService;
    private final GenelBilgilerService genelBilgilerService;

    public HalController(UserService userService, HalUserService halUserService, GenelBilgilerService genelBilgilerService) {
        this.userService = userService;
        this.halUserService = halUserService;
        this.genelBilgilerService = genelBilgilerService;
    }

    @GetMapping
    public String main(Model model, Principal principal){
        model.addAttribute("user",userService.getUserByUserName(principal.getName()));
        return "hal/main";
    }

    @GetMapping("/cari/cariList")
    public String cariList(Model model){
        System.out.println(halUserService.getAllHalUsers().get(0).getUser().getFirstname());
        System.out.println(halUserService.getAllHalUsers().get(0).getHalRole().getName());
        model.addAttribute("cariList",halUserService.getAllHalUsers());
        return "hal/cari/cariList";
    }
}
