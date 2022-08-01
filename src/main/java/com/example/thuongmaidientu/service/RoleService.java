package com.example.thuongmaidientu.service;


import com.example.thuongmaidientu.model.Role;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
    Iterable<String>findNameRole();
}
