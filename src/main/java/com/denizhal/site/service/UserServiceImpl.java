package com.denizhal.site.service;

import com.denizhal.site.model.User;
import com.denizhal.site.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUserName(String email) {
        return userRepository.findByEmail(email).get();
    }
}
