package com.denizhal.site.controller;


import com.denizhal.site.model.Kurumsal;
import com.denizhal.site.model.User;
import com.denizhal.site.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    private final AdminService adminService;
    private final RoleService roleService;
    private final KurumsalService kurumsalService;
    private final FileService fileService;
    private final ContactService contactService;

    public AdminHomeController(AdminService adminService, RoleService roleService, KurumsalService kurumsalService, FileService fileService, ContactService contactService) {
        this.adminService = adminService;
        this.roleService = roleService;
        this.kurumsalService = kurumsalService;
        this.fileService = fileService;
        this.contactService = contactService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("kurumsal",kurumsalService.getKurumsal());
        model.addAttribute("users", adminService.getUsers());
        model.addAttribute("iletisim",contactService.getContacts());
        return "admin/adminhome";
    }

    @GetMapping("/users")
    public String users(Model model){
        System.out.println("test123");
        model.addAttribute("users", adminService.getUsers());
        return "admin/users";
    }

    /* Deprecated
    @GetMapping("/roles")
    public String roles(Model model){
        model.addAttribute("roles",roleService.getRoles());
        return "roles/listRoles";
    }
    */


    @GetMapping("/users/new")
    public String newUsers(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",roleService.getRoles());
        return "admin/newuser";
    }

    @GetMapping("/user/{id}/update")
    public String updateUser(@PathVariable String id,Model model){
        model.addAttribute("user",adminService.findUser(Integer.valueOf(id)));
        model.addAttribute("roles",roleService.getRoles());
        return "admin/updateuser";
    }

    @GetMapping("/{id}/update")
    public String updateKurumsal(@PathVariable int id,Model model){
        model.addAttribute("kurumsal",kurumsalService.getKurumsalById(id));
        return "kurumsal/kurumsalUpdate";
    }

    @GetMapping("/user/{id}/show")
    public String showUser(@PathVariable String id, Model model){
        model.addAttribute("user",adminService.findUser(Integer.valueOf(id)));
        return "admin/showUser";
    }

    //Todo delete özelliğine emin misiniz sorusunu ekle
    @GetMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable String id){
        adminService.delete(Integer.valueOf(id));
        return "redirect:/admin/users";
    }

    @PostMapping("/users/new")
    public String handlingSave(@ModelAttribute("user") User user){
        adminService.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/user/update")
    public String handlingUpdate(@ModelAttribute("user") User user){
        adminService.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/kurumsal/update")
    public String handlingKurumsalUpdate(@RequestParam MultipartFile foto_1,
                                         @RequestParam MultipartFile foto_2,
                                         @RequestParam MultipartFile foto_3,
                                         @ModelAttribute("kurumsal") Kurumsal kurumsal){
        Path filePath= Paths.get("src\\main\\uploads");
        if(!foto_1.isEmpty()){
            try{
                fileService.uploadFile(foto_1,filePath);
            }catch (Exception e){
                e.printStackTrace();
            }
            kurumsal.setFoto_url_1("\\src\\main\\uploads\\"+foto_1.getOriginalFilename());
        }
        if(!foto_2.isEmpty()){
            try{
                fileService.uploadFile(foto_2,filePath);
            }catch (Exception e){
                e.printStackTrace();
            }
            kurumsal.setFoto_url_2("\\src\\main\\uploads\\"+foto_2.getOriginalFilename());
        }
        if(!foto_3.isEmpty()){
            try{
                fileService.uploadFile(foto_3,filePath);
            }catch (Exception e){
                e.printStackTrace();
            }
            kurumsal.setFoto_url_3("\\src\\main\\uploads\\"+foto_3.getOriginalFilename());
        }

        kurumsal.setSavedate(LocalDate.now());
        kurumsalService.save(kurumsal);
        return "redirect:/admin";

    }





}
