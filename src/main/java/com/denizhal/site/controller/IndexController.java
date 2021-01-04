package com.denizhal.site.controller;

import com.denizhal.site.exception.NotFoundException;
import com.denizhal.site.model.Contact;
import com.denizhal.site.model.News;
import com.denizhal.site.repositories.UserRepository;
import com.denizhal.site.service.KurumsalService;
import com.denizhal.site.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
public class IndexController {


    private final NewsServiceImpl newsService;
    private final KurumsalService kurumsalService;

    public IndexController(NewsServiceImpl newsService, KurumsalService kurumsalService) {
        this.newsService = newsService;
        this.kurumsalService = kurumsalService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("kurumsal",kurumsalService.getKurumsal());
        model.addAttribute("iletisim",new Contact());
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("kurumsal",kurumsalService.getKurumsal());
        model.addAttribute("iletisim",new Contact());
        return "index";
    }

    @GetMapping("/iletisim")
    public String contact(Model model){
        model.addAttribute("iletisim",new Contact());
        return "iletisim";
    }

    @GetMapping("/haberler")
    public String haberler(Model model){
        /*
        List<News> haberler=newsService.getNews();
        model.addAttribute("haberler",haberler);

         */
        model.addAttribute("topNews",newsService.getTopList());
        return pageAndSort("1",model);
    }
    @GetMapping("/haberler/search")
    public String arama(@RequestParam(name="keyword") String keyword,Model model){
        return aramaPage("1",keyword,model);
    }

    @GetMapping("/haberler/search/{pageNo}")
    public String aramaPage(@PathVariable String pageNo,@RequestParam(name = "keyword") String keyword, Model model){
        //Hatayı arıyorum
        try {
            Integer newID=Integer.parseInt(pageNo);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Girilen ifade sayı değildir :"+keyword);
        }

        Pageable pageable=PageRequest.of(Integer.valueOf(pageNo)-1,5,Sort.by("savedate").descending());
        Page<News> pageSearch=newsService.searchNews(keyword,pageable);
        List<News> haberler=pageSearch.getContent();
        haberler=newsService.shortNews(haberler);
        model.addAttribute("haberler",haberler);
        model.addAttribute("currentPage",Integer.valueOf(pageNo));
        model.addAttribute("totalPages",pageSearch.getTotalPages());
        model.addAttribute("totalItems",pageSearch.getTotalElements());
        System.out.println("current page:"+ pageNo +" total pages: "+pageSearch.getTotalPages()+ " totalItems: "+pageSearch.getTotalElements());
        model.addAttribute("topNews",newsService.getTopList());
        return "haberler";
    }

    @GetMapping("/haberler/{pageNo}")
    public String pageAndSort(@PathVariable String pageNo, Model model)
    {
        try {
            Integer newID=Integer.parseInt(pageNo);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Girilen ifade sayı değildir :"+pageNo);
        }

        Pageable pageable = PageRequest.of(Integer.valueOf(pageNo)-1,5, Sort.by("savedate").descending());
        Page<News> pagedHaberler=newsService.findPaginated(pageable);
        List<News> haberler=pagedHaberler.getContent();
        haberler=newsService.shortNews(haberler);
        model.addAttribute("haberler",haberler);
        model.addAttribute("currentPage",Integer.valueOf(pageNo));
        model.addAttribute("totalPages",pagedHaberler.getTotalPages());
        model.addAttribute("totalItems",pagedHaberler.getTotalElements());
        System.out.println("current page:"+ pageNo +" total pages: "+pagedHaberler.getTotalPages()+ " totalItems: "+pagedHaberler.getTotalElements());
        model.addAttribute("topNews",newsService.getTopList());
        return "haberler";
    }


    @GetMapping("/haberler/{id}/{title}")
    public String newsDetails(@PathVariable String id,Model model){
        //Burada haber detayını istediğinde ziyaret sayısını 1 arttırmak istiyorum
        //Hatayı arıyorum
        try {
            Integer newID=Integer.parseInt(id);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Girilen ifade sayı değildir :"+id);
        }

        newsService.ziyaretciArttir(Integer.valueOf(id));
        model.addAttribute("news",newsService.getNew(Integer.valueOf(id)));
        //model.addAttribute("haberler",newsService.getNews());
        model.addAttribute("topNews",newsService.getTopList());
        return "haberDetails";
    }

    @GetMapping("/products")
    public String products(Model model){
        String title="Deniz Hal Yazılımı";
        model.addAttribute("title",title);
        return "products";
    }


}
