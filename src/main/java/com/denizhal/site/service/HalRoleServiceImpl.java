package com.denizhal.site.service;

import com.denizhal.site.model.HalRole;
import com.denizhal.site.repositories.HalRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class HalRoleServiceImpl implements HalRoleService {
    private final HalRoleRepository halRoleRepository;

    public HalRoleServiceImpl(HalRoleRepository halRoleRepository) {
        this.halRoleRepository = halRoleRepository;
    }

    @Override
    public HalRole getHalRole(Integer id) {
        Optional<HalRole> optionalHalRole=halRoleRepository.findById(id);
        if(!optionalHalRole.isPresent()){
            log.error("Cari'nin türü bulunamamıştır. :"+id);
        }
        HalRole halRole=optionalHalRole.get();
        return halRole;
    }
}
