package com.denizhal.site.controller;

import com.denizhal.site.model.HalUser;
import com.denizhal.site.service.HalUserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HalRestController {

    private final HalUserService halUserService;

    public HalRestController(HalUserService halUserService) {
        this.halUserService = halUserService;
    }

    @GetMapping("/hal/{userid}/{halroleid}/musteriid")
    public Integer musteriKodu(@PathVariable(name="userid") Integer userid,@PathVariable(name="halroleid") Integer halroleid){
        System.out.println("kullanıcıid : "+userid+" halroleid : "+halroleid);
        //HalUser lastHalUser=halUserService.getLastUserByHalRoleId(halroleid);
        HalUser lastHalUser=halUserService.getLastUserByIdAndHalRoleId(userid,halroleid);
        if(lastHalUser==null){
            return 1;
        }
        System.out.println(lastHalUser.getMusteriKodu());
//        return String.valueOf(lastHalUser.getMusteriKodu()+1);
        return lastHalUser.getMusteriKodu()+1;
    }

    @PostMapping("/hal/chechtc")
    public String chechTc(@Param("id") Integer id, @Param("tckimlik") String tckimlik){
        System.out.println("id : "+id +" tc kimlik : "+tckimlik);
        //TODO önce tc kimlik numarasının valid olup olmadığına bakalım sonra bu kaydın daha önce yapılıp yapılmadığına
        if(tckimlik.equals("")){
            System.out.println("tc kimlik alanı boş...");
            return "NULLTC";
        }else if(halUserService.chechUniqueTcAndUser(id,tckimlik)){
            System.out.println("kullanıcı var");
            return "Dublicated";
        }else{
            System.out.println("kullanıcı yok");
            return "OK";
        }
    }
    @PostMapping("/hal/chechtcupdate")
    public String chechTcUpdate(@Param("id") Integer id, @Param("tckimlik") String tckimlik,@Param("musteriKodu") String musteriKodu, @Param("halRoleId") String halRoleId){
        System.out.println("id : "+id +" tc kimlik : "+tckimlik +"müşteri kodu:"+musteriKodu+"halRoleId:"+halRoleId);
        //TODO önce tc kimlik numarasının valid olup olmadığına bakalım sonra bu kaydın daha önce yapılıp yapılmadığına
        HalUser halUser=halUserService.getHalUserByUserIdAndMusteriKoduAndHalRoleId(id,Integer.valueOf(musteriKodu),Integer.valueOf(halRoleId));
        if(tckimlik.equals("")){
            System.out.println("tc kimlik alanı boş...");
            return "NULLTC";
        }else if(tckimlik.equals(halUser.getTcKimlikNo())){
            System.out.println("Aynı kullanıcı");
            return "OK";
        }
        else if(halUserService.chechUniqueTcAndUser(id,tckimlik)){
            System.out.println("kullanıcı var");
            return "Dublicated";
        }else{
            System.out.println("kullanıcı yok");
            return "OK";
        }
    }

//    @PostMapping("/hal/chechtc")
//    public ResponseEntity chechTc(@Param("id") Integer id, @Param("tckimlik") String tckimlik, Model model){
//        System.out.println("id : "+id +" tc kimlik : "+tckimlik);
//        //TODO önce tc kimlik numarasının valid olup olmadığına bakalım sonra bu kaydın daha önce yapılıp yapılmadığına
//        //model.addAttribute("mesaj","Bu kullanıcı daha önce eklenmiş");
//        if(halUserService.chechUniqueTcAndUser(id,tckimlik)){
//            System.out.println("kullanıcı var");
//            return new ResponseEntity("Kullanıcı daha önce eklenmiştir.", HttpStatus.NOT_FOUND);
//        }else{
//            return new ResponseEntity("Kullanıcıyı ekleyebilirsiniz", HttpStatus.OK);
//        }
//    }


}
