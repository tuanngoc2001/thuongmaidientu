package com.example.thuongmaidientu.controller;

import com.example.thuongmaidientu.model.Product;
import com.example.thuongmaidientu.repository.ProductRepository;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(productRepository.findById(id), HttpStatus.OK);
    }
    @GetMapping("/name")
    public ResponseEntity findAllByName(@RequestParam String name)
    {
        return new ResponseEntity(productRepository.findAllByNameContaining(name), HttpStatus.OK);
    }
@GetMapping("/phantrang-name")
public ResponseEntity<Iterable<Product>> findAllByNameContaining(@RequestParam String name,@PageableDefault(size = 3) Pageable pageable) {
    return new ResponseEntity<>(productRepository.findAllByNameContaining(pageable, name), HttpStatus.OK);
}

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        return new ResponseEntity(productRepository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> oldAnswer = productRepository.findById(id);
        if (!oldAnswer.isPresent()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        product.setId(id);
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
