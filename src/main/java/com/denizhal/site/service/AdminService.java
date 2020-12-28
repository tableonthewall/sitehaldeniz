package com.denizhal.site.service;

import com.denizhal.site.dto.UserDto;
import com.denizhal.site.model.User;

import java.util.List;

public interface AdminService {
    List<User> getUsers();
    User save(User user);
    User findUser(Integer id);
    User findUserByEmail(String email);
    void delete(Integer id);
}
