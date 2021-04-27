package com.denizhal.site.controller;

import com.denizhal.site.model.GenelBilgiler;
import com.denizhal.site.model.HalRole;
import com.denizhal.site.model.HalUser;
import com.denizhal.site.service.GenelBilgilerService;
import com.denizhal.site.service.HalRoleService;
import com.denizhal.site.service.HalUserService;
import com.denizhal.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hal")
public class HalController {
    private final UserService userService;
    private final HalUserService halUserService;
    private final GenelBilgilerService genelBilgilerService;
    private final HalRoleService halRoleService;

    public HalController(UserService userService, HalUserService halUserService, GenelBilgilerService genelBilgilerService, HalRoleService halRoleService) {
        this.userService = userService;
        this.halUserService = halUserService;
        this.genelBilgilerService = genelBilgilerService;
        this.halRoleService = halRoleService;
    }

    @GetMapping
    public String main(Model model, Principal principal){
        model.addAttribute("user",userService.getUserByUserName(principal.getName()));
        //System.out.println(userService.getUserByUserName(principal.getName()).getId());
        return "hal/main";
    }

    @GetMapping("/cari/{userid}/cariList")
    public String cariList(@PathVariable("userid") Integer userId, Model model){
        //System.out.println(halUserService.getAllHalUsers().get(0).getUser().getFirstname());
        //System.out.println(halUserService.getAllHalUsers().get(0).getHalRole().getName());
        model.addAttribute("user",userService.getUser(userId));
        model.addAttribute("cariList",halUserService.getAllHalUsersByUserId(userId));
        return "hal/cari/cariList";
    }
    @GetMapping("/cari/add")
    public String addCari(Model model,Principal principal){
        HalUser halUser=new HalUser();
        //TODO boş genel bilgiler nesnesi gönderiliyor. Genel bilgiler nesnesini yaratmadan referanssız olarak gönderdiğimizde eleman bize geri dönmüyor.
        GenelBilgiler genelBilgiler=new GenelBilgiler();
        //TODO buralar düzeltilecek

        genelBilgiler.setTelNo("054343434");
        halUser.setGenelBilgiler(genelBilgiler);
        halUser.setUser(userService.getUserByUserName(principal.getName()));
        halUser.setHalRole(new HalRole());
        List<HalRole> halRoles=halRoleService.getHalRoles();
        model.addAttribute("halRoles",halRoles);
        model.addAttribute("halUser",halUser);
        System.out.println(halUser.getUser().getId());

        for(HalRole role:halRoles){
            System.out.println("id:"+role.getId()+"name:"+role.getName());
        }

        return "hal/cari/addCari";
    }
    @GetMapping("/{userid}/cari/{musteriKodu}/{halRoleId}/update")
    public String updateCari(@PathVariable("userid") Integer userid,@PathVariable("musteriKodu")Integer musteriKodu,@PathVariable("halRoleId") Integer halRoleId, Model model,Principal principal){
        HalUser halUser=halUserService.getHalUserByUserIdAndMusteriKoduAndHalRoleId(userid,musteriKodu,halRoleId);
        halUser.setGenelBilgiler(new GenelBilgiler());
        halUser.setUser(userService.getUserByUserName(principal.getName()));
        System.out.println("hal role id:"+halUser.getHalRole().getId());
        List<HalRole> halRoles=halRoleService.getHalRoles();
        model.addAttribute("halRoles",halRoles);
        model.addAttribute("halUser",halUser);
        System.out.println(halUser.getUser().getId());

        for(HalRole role:halRoles){
            System.out.println("id:"+role.getId()+"name:"+role.getName());
        }

        return "hal/cari/updateCari";
    }


    //DELETE
    @GetMapping("/{userid}/{cariid}/delete")
    public String deleteCari(@PathVariable("userid")Integer userid,@PathVariable("cariid") Integer cariid){

        halUserService.deleteHalUser(cariid);

        return "redirect:/hal/cari/"+userid+"/cariList?successDelete";
    }
    //ADD NEW CARİ
    @PostMapping("/cari/new")
    public String newCari(@ModelAttribute("halUser") HalUser halUser){
        //TODO cari ekleme fonksiyonları yazılacak..
        System.out.println("genel bilgiler : "+halUser.getGenelBilgiler());
        System.out.println("genel bilgiler tel: "+halUser.getGenelBilgiler().getTelNo());
        System.out.println(halUser.getGenelBilgiler().getSifati());
        halUserService.save(halUser);
//        if(halUser!=null){
//            System.out.println("nesne geldi");
//            System.out.println(halUser.getAdi()+" "+halUser.getMusteriKodu()+" "+halUser.getHalRole().getName());
//        }else{
//            System.out.println("nesne gelmedi");
//        }
        return "redirect:/hal/cari/"+halUser.getUser().getId()+"/cariList?success";
    }

    //UPDATE
    @PostMapping("cari/update")
    public String updateCari(@ModelAttribute("halUser") HalUser halUser){
        HalUser oldHalUser=halUserService.getHalUser(halUser.getId());
        if(oldHalUser.equals(halUser)){
            return "redirect:/hal/cari/"+halUser.getUser().getId()+"/cariList";
        }else{
            System.out.println("Güncellenme olmuştur.");
        }
        halUserService.save(halUser);
        return "redirect:/hal/cari/"+halUser.getUser().getId()+"/cariList?successUpdate";
    }
}
