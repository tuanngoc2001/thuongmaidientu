package com.example.thuongmaidientu.controller;

import com.example.thuongmaidientu.model.Role;
import com.example.thuongmaidientu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/roles")
public class RoleController {
    @Autowired
    private RoleRepository repository;
    @GetMapping
    public ResponseEntity<Role>getName(@RequestParam String name)
    {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Iterable<String>>getRole()
    {
        return new ResponseEntity<>(repository.findNameRole(), HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity<Iterable<Role>> findAllByNameContaining(@RequestParam String name,@PageableDefault(size = 2) Pageable pageable) {
        return new ResponseEntity<>(repository.findAllByNameContaining(pageable, name), HttpStatus.OK);
    }
}
