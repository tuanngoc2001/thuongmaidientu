package com.example.thuongmaidientu.repository;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
     Page<Bill>findAllByUserIdAndStatus(Pageable pageable,int id,int status);
     Iterable<Bill>findAllByStatus(int status);
     Iterable<Bill>findAllByUserId(int id);
     Bill findById(int id);
     Page<Bill> findAllByNameContaining(Pageable pageable, String name);

}
