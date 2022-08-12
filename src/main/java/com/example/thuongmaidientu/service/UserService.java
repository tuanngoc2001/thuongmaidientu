package com.example.thuongmaidientu.service;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.Optional;

public interface UserService extends UserDetailsService {
    void save(User user);

    Iterable<User> findAll();


    User findByUsername(String username);

    User getCurrentUser();

    Optional<User> findById(Integer id);

    UserDetails loadUserById(Integer id);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);

}