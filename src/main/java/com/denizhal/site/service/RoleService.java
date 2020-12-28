package com.denizhal.site.service;

import com.denizhal.site.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role getRole(Integer id);
    void save(Role role);
    void delete(Integer id);
}
