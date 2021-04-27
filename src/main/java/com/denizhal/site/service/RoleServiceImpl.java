package com.denizhal.site.service;

import com.denizhal.site.model.Role;
import com.denizhal.site.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Integer id) {
        Optional<Role> optionalRole=roleRepository.findById(id);
        if(!optionalRole.isPresent()){
            log.error("Rol bilgisine ulaşılamadı."+id);
        }

        Role role=optionalRole.get();
        role.setName(role.getName().substring(role.getName().indexOf("_")+1));
        return role;

    }

    @Override
    public void save(Role role) {
        //ROLE_ ön ekini burada ekliyoruz.
        role.setName(new String("ROLE_"+role.getName()));
        roleRepository.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
