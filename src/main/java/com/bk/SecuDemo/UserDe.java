package com.bk.SecuDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDe implements UserDetailsService  {

    @Autowired
    private SecRepo secRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users us=secRepo.findByUsername(username);
        if(us==null){
          throw new UsernameNotFoundException("User Not Found In "+username);
        }
       return User.builder()
       .username(us.getUsername())
       .password(us.getPassword())
       .roles(us.getRole().name())
       .build();
    }
    
}
