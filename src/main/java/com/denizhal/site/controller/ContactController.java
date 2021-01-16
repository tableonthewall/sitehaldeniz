package com.denizhal.site.controller;

import com.denizhal.site.model.Contact;
import com.denizhal.site.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{id}/delete")
    public String deleteContact(@PathVariable int id){
        contactService.delete(id);
        return "redirect:/admin#profile";
    }

    @PostMapping("/new")
    public String newContact(@Valid @ModelAttribute("iletisim")Contact iletisim, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/iletisim";
        }
        iletisim.setSavedate(LocalDate.now());
        contactService.save(iletisim);
        return "redirect:/iletisim?success";
    }
}
