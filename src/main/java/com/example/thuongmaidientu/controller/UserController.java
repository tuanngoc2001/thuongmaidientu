package com.example.thuongmaidientu.controller;

import com.example.thuongmaidientu.model.User;
import com.example.thuongmaidientu.respon.UserRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRespon userRespon;
    @GetMapping("")
    public ResponseEntity findALlUser(){
        return new ResponseEntity(userRespon.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity addUser(@RequestBody User user){
        userRespon.save(user);
        return new ResponseEntity( HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity findByContent(String username){
        return new ResponseEntity(userRespon.findAllByUsernameContaining(username),HttpStatus.OK);
    }
//    @GetMapping("/search-by-name")
//    public ResponseEntity<Iterable<User>> findAllByNameContaining(@RequestParam String name,@PageableDefault(size = 3) Pageable pageable) {
//        return new ResponseEntity<>(userRespon.findAllByUsernameContaining(pageable, name), HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity QuestionUpdate(@PathVariable Long id, @RequestBody User user){
        Optional<User> oldName = userRespon.findById(id);
        if(!oldName.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        userRespon.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    //done
    @DeleteMapping("/{id}")
    public ResponseEntity DeleteQuestion(@PathVariable Long id){
        Optional<User> oldName = userRespon.findById(id);
        if(!oldName .isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userRespon.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
