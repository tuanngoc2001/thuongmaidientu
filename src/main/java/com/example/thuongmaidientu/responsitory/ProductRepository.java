package com.example.thuongmaidientu.responsitory;

import com.example.thuongmaidientu.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByNameContaining(Pageable pageable, String name);
    List<Product> findAllByNameContaining( String name);
}