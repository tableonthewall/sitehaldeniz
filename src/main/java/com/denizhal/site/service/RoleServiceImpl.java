package com.denizhal.site.service;

import com.denizhal.site.model.Role;
import com.denizhal.site.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(optionalRole.isPresent()){
            Role role=optionalRole.get();
            role.setName(role.getName().substring(role.getName().indexOf("_")+1));
            System.out.println(role.getName());
            return role;
        }else{
            return null;
        }
    }

    @Override
    public void save(Role role) {
        role.setName(new String("ROLE_"+role.getName()));
        roleRepository.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
