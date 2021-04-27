package com.denizhal.site.repositories;

import com.denizhal.site.model.HalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HalUserRepository extends JpaRepository<HalUser,Integer> {
    List<HalUser> findByHalRoleIdOrderByIdDesc(Integer id);
    List<HalUser> findAllByUserId(Integer userId);
    Optional<HalUser> findTopByHalRoleIdOrderByIdDesc(Integer id);
    //HalKullanıcısına (Mustahsil-Müşteri) ait son kaydı bulan ve getiren metot:
    Optional<HalUser> findTopByUserIdAndHalRoleIdOrderByIdDesc(Integer userId,Integer halRoleId);
    Optional<HalUser> findByUserIdAndMusteriKodu(Integer userId,Integer musteriKodu);
    Optional<HalUser> findByUserIdAndMusteriKoduAndHalRoleId(Integer userId,Integer musteriKodu,Integer halRoleId);
    boolean existsByUserIdAndTcKimlikNo(Integer userId,String tcKimlikNo);
}
