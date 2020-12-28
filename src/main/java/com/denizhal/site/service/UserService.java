package com.denizhal.site.service;

import com.denizhal.site.model.User;

public interface UserService {
    User getUser(Integer id);
    User getUserByUserName(String email);
}
