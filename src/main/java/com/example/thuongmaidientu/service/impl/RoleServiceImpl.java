package com.example.thuongmaidientu.service.impl;

import com.example.thuongmaidientu.model.Role;
import com.example.thuongmaidientu.repository.RoleRepository;
import com.example.thuongmaidientu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Iterable<String> findNameRole() {
        return roleRepository.findNameRole();
    }

    @Override
    public Page<Role> findAllByNameContaining(Pageable pageable, String name) {
        return roleRepository.findAllByNameContaining(pageable,name);
    }



}