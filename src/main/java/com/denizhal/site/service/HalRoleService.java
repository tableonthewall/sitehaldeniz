package com.denizhal.site.service;

import com.denizhal.site.model.HalRole;

import java.util.List;


public interface HalRoleService {
    HalRole getHalRole(Integer id);
    List<HalRole> getHalRoles();
}
