package com.denizhal.site.service;

import com.denizhal.site.model.HalUser;

import java.util.List;

public interface HalUserService {
    HalUser getHalUser(Integer id);
    List<HalUser> getAllHalUsers();
}
