package com.example.thuongmaidientu.respon;

import com.example.thuongmaidientu.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRespon extends JpaRepository<User, Long> {
    List<User> findAllByUsernameContaining(String username);
    Page<User> findAllByUsernameContaining(Pageable pageable, String name);
}
