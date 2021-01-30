package com.denizhal.site.service;

import com.denizhal.site.model.HalUser;

import java.util.List;
import java.util.Optional;

public interface HalUserService {
    HalUser getHalUser(Integer id);
    List<HalUser> getAllHalUsers();
    List<HalUser> getAllHalUsersByUserId(Integer id);
    HalUser getLastUserByHalRoleId(Integer id);
    //Belirli bir kullanıcının eklediği (mustahsil ya da müşteri) numarasına göre oluşturulan son kaydı bulup getiren metot...
    HalUser getLastUserByIdAndHalRoleId(Integer userId,Integer halRoleId);
    HalUser getHalUserByUserIdAndMusteriKodu(Integer userId,Integer musteriKodu);
    HalUser getHalUserByUserIdAndMusteriKoduAndHalRoleId(Integer userId,Integer musteriKodu,Integer halRoleId);
    boolean chechUniqueTcAndUser(Integer userId,String tc);
    void save(HalUser halUser);
}
