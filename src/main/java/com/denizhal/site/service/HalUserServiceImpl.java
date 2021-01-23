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
}
