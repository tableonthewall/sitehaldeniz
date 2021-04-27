package com.denizhal.site.service;

import com.denizhal.site.model.User;
import com.denizhal.site.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1) Optional<User> user2=userRepository.findByEmail(username);
        //1) user2.orElseThrow(()-> new UsernameNotFoundException("Kullanıcı bulunamadı."));
        User user=userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Email "+username+" kullanıcı bulunamamıştır."));
        //System.out.println("bulduğum email : "+user.getEmail()+" "+user.getFirstname()+" "+user.getRoles());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));
        //return user2.map(AuthenticatedUser::new).get();
    }
    //bulunan kullanıcının yetkileri (authorities) bulunup liste olarak geri döndürülüyor ve yukarıdaki metoda veriliyor.
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        for(int i=0;i<userRoles.length;i++){
            System.out.println(authorities.stream().count());
        }
        return authorities;
    }
}
