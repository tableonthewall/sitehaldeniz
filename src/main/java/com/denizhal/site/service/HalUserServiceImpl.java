package com.denizhal.site.service;

import com.denizhal.site.model.HalRole;
import com.denizhal.site.model.HalUser;
import com.denizhal.site.repositories.HalUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HalUserServiceImpl implements HalUserService {
    private final HalUserRepository halUserRepository;

    public HalUserServiceImpl(HalUserRepository halUserRepository) {
        this.halUserRepository = halUserRepository;
    }

    @Override
    public HalUser getHalUser(Integer id) {
        Optional<HalUser> optionalHalUser=halUserRepository.findById(id);
        if(!optionalHalUser.isPresent()){
            log.error("Cari kartı bilgileri bulunamamıştır. :"+id);
        }
        HalUser halUser=optionalHalUser.get();
        return halUser;
    }

    @Override
    public List<HalUser> getAllHalUsers() {
        return halUserRepository.findAll();
    }

    @Override
    public List<HalUser> getAllHalUsersByUserId(Integer id) {
        return halUserRepository.findAllByUserId(id);
    }

    @Override
    public HalUser getLastUserByHalRoleId(Integer id) {
        //List<HalUser> getAllUsersByHalRoleId=halUserRepository.findByHalRoleIdOrderByIdDesc(id);
        Optional<HalUser> optionalHalUser=halUserRepository.findTopByHalRoleIdOrderByIdDesc(id);
        System.out.println("adi :"+optionalHalUser.get().getAdi());
        HalUser halUser=new HalUser();
        if(!optionalHalUser.isPresent()){
            log.error("Son hal kullanıcısı bulunamıştır : "+id);
            halUser.setMusteriKodu(1);
        }
        halUser=optionalHalUser.get();
        return halUser;
    }

    @Override
    public HalUser getLastUserByIdAndHalRoleId(Integer userId, Integer halRoleId) {
        Optional<HalUser> optionalHalUser=halUserRepository.findTopByUserIdAndHalRoleIdOrderByIdDesc(userId,halRoleId);


        HalUser halUser=new HalUser();
        if(!optionalHalUser.isPresent()){
            System.out.println("kullanıcı bulunamadı");
            log.error("Kullanıcıya ait son hal kullanıcısı bulunamadı");
            return new HalUser();

        }
        //System.out.println("adi :"+optionalHalUser.get().getAdi());
        halUser=optionalHalUser.get();
        return halUser;
    }

    @Override
    public HalUser getHalUserByUserIdAndMusteriKodu(Integer userId, Integer musteriKodu) {
        Optional<HalUser> optionalHalUser=halUserRepository.findByUserIdAndMusteriKodu(userId,musteriKodu);
        HalUser halUser=new HalUser();
        if(!optionalHalUser.isPresent()){
            log.error("Kullanıcıya ait hal kullanıcısı bulunamamıştır.");
        }
        halUser=optionalHalUser.get();
        return halUser;
    }

    @Override
    public HalUser getHalUserByUserIdAndMusteriKoduAndHalRoleId(Integer userId, Integer musteriKodu, Integer halRoleId) {
        return halUserRepository.findByUserIdAndMusteriKoduAndHalRoleId(userId,musteriKodu,halRoleId).get();
    }

    @Override
    public boolean chechUniqueTcAndUser(Integer userId, String tc) {
        return halUserRepository.existsByUserIdAndTcKimlikNo(userId,tc);

    }

    @Override
    public void save(HalUser halUser) {
        halUserRepository.save(halUser);
    }

    @Override
    public void deleteHalUser(Integer id) {
        halUserRepository.deleteById(id);
    }



}
