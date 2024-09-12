package com.bk.SecuDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private SecRepo secRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users saveUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return secRepo.save(users);
    }

   
}
