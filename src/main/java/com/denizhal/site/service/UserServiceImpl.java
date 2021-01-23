package com.denizhal.site.service;

import com.denizhal.site.model.User;
import com.denizhal.site.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if(!optionalUser.isPresent()){
            log.error("Kullanıcı bulunamadı: "+id);
        }
        User user=optionalUser.get();
        return user;
    }

    @Override
    public User getUserByUserName(String email) {
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if(!optionalUser.isPresent()){
            log.error("Email'i verilen kullanıcı bulunamadı : "+email);
        }
        User user=optionalUser.get();
        return user;
    }
}
