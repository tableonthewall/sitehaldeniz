package com.denizhal.site.controller;

import com.denizhal.site.model.News;
import com.denizhal.site.service.AdminService;
import com.denizhal.site.service.FileService;
import com.denizhal.site.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;
    private final AdminService adminService;
    private final FileService fileService;


    public NewsController(NewsService newsService, AdminService adminService, FileService fileService) {
        this.newsService = newsService;
        this.adminService = adminService;
        this.fileService = fileService;
    }

    @GetMapping
    public String listNews(Model model){
        model.addAttribute("news",newsService.getNews());
        return "news/listNews";
    }



    @GetMapping("/new")
    public String saveNews(Model model){
       model.addAttribute("news",new News());
        return "news/newNews";
    }

    @GetMapping("/{id}/show")
    public String showNews(@PathVariable String id,Model model){
        try {
            Integer newID=Integer.parseInt(id);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Girilen ifade sayı değildir :"+id);
        }
        model.addAttribute("news",newsService.getNew(Integer.valueOf(id)));
        return "news/newsDetails";
    }

    @GetMapping("/{id}/update")
    public String updateNews(@PathVariable String id,Model model){
        model.addAttribute("news",newsService.getNew(Integer.valueOf(id)));
        return "news/updateNews";
    }

    @GetMapping("/{id}/delete")
    public String deleteNews(@PathVariable String id,Model model){
        newsService.delete(Integer.valueOf(id));
        return "redirect:/news";
    }
    //Eğer gönderdiğim fotoğraf değiştirilmiyor ise yani file empty ise if çalışmadan diğer kısımlar güncellenir.
    @PostMapping("/update")
    public String handlingUpdate(@RequestParam MultipartFile file,@ModelAttribute News news,Principal principal,Model model){
        if(!file.isEmpty()){
            Path root = Paths.get("src/main/uploads");
            try {
                fileService.uploadFile(file,root);
            }catch (Exception e){
                e.printStackTrace();
            }
            news.setFoto_url("/src/main/uploads/" +file.getOriginalFilename());
        }
        news.setUser(adminService.findUserByEmail(principal.getName()));
        newsService.save(news);
        return "redirect:/news";
    }

    @PostMapping("/new")
    public String handlingSaveNews(@RequestParam MultipartFile file, @ModelAttribute News news,
                                   Principal principal, Model model){
        Path root = Paths.get("src/main/uploads");
        try {
            fileService.uploadFile(file,root);

        }catch (Exception e){
            e.printStackTrace();
        }

        news.setFoto_url("/src/main/uploads/" +file.getOriginalFilename());
        news.setZiyaret(0);
        news.setUser(adminService.findUserByEmail(principal.getName()));
        newsService.save(news);
        return "redirect:/news";
    }


}
