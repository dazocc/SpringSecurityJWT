package br.com.dazo.examplespringsecurityjwt.service;

import br.com.dazo.examplespringsecurityjwt.entity.UserEntity;
import br.com.dazo.examplespringsecurityjwt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity user = iUserRepository.findByUserName(userName);

        List<GrantedAuthority> authorityList = null;

        if(user.getUserName().equals("dazo")){
            authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        } else{
            authorityList = AuthorityUtils.createAuthorityList("ROLE_USER");
        }

        return new User(user.getUserName(), user.getPassword(), authorityList);
    }
}
