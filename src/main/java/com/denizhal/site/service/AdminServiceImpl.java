package com.denizhal.site.service;

import com.denizhal.site.model.User;
import com.denizhal.site.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


}
