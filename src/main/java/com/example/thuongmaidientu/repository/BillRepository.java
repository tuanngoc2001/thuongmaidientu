package com.example.thuongmaidientu.repository;

import com.example.thuongmaidientu.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
     Iterable<Bill>findAllByUserIdAndStatus(int id,int status);
     Iterable<Bill>findAllByStatus(int status);
     Iterable<Bill>findAllByUserId(int id);
     Bill findById(int id);

}
