package com.example.thuongmaidientu.service;


import com.example.thuongmaidientu.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
    Iterable<String>findNameRole();
    Page<Role> findAllByNameContaining(Pageable pageable, String name);
}