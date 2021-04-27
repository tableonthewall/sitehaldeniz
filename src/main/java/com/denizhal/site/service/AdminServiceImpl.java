package com.denizhal.site.service;

import com.denizhal.site.model.User;
import com.denizhal.site.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        //user'dan gelen değerlerden şifre kısmını BCrypt olarak encode ettikten sonra veritabanına aktarıyorum.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUser(Integer id) {
        Optional<User> userOptional=userRepository.findById(id);

        if(!userOptional.isPresent()){
            log.error("Kullanıcı bulunamadı : "+id);
        }
        User user=userOptional.get();

        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(!userOptional.isPresent()){
            log.error("Kullanıcı bulunamadı : "+email);
        }
        User user=userOptional.get();
        return user;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


}
