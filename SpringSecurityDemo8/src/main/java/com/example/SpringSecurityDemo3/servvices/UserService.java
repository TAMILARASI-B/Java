package com.example.SpringSecurityDemo3.servvices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityDemo3.model.Users;
import com.example.SpringSecurityDemo3.repos.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }
}