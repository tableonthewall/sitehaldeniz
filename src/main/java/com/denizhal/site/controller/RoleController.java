package com.denizhal.site.controller;

import com.denizhal.site.model.Role;
import com.denizhal.site.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String roles(Model model){
        model.addAttribute("roles",roleService.getRoles());
        return "roles/listRoles";
    }

    @GetMapping("/{id}/show")
    public String roleDetails(@PathVariable int id,Model model){
        model.addAttribute("role",roleService.getRole(id));
        return "roles/detailRoles";
    }

    @GetMapping("/new")
    public String newRole(Model model){
        Role role=new Role();
        role.setUsers(new ArrayList<>());
        model.addAttribute("role",role);
        return "roles/newRole";
    }

    @GetMapping("/{id}/update")
    public String updateRole(@PathVariable int id, Model model){
        model.addAttribute("role",roleService.getRole(id));
        return("roles/updateRole");
    }
    //TODO delete cascade üzerinden düzenlenecek
    @GetMapping("/{id}/delete")
    public String deleteRole(@PathVariable int id){
        roleService.delete(id);
        return "redirect:/admin/roles";
    }

    @PostMapping("/new")
    public String handlingRole(@ModelAttribute("role") Role role){
        roleService.save(role);
        return "redirect:/admin/roles";
    }

    @PostMapping("/update")
    public String updateHandling(@ModelAttribute("role") Role role){
        roleService.save(role);
        return "redirect:/admin/roles";
    }



}
