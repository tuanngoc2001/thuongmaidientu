package com.example.thuongmaidientu.service;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BillService {

    Page<Bill>findAllByUserIdAndStatus(Pageable pageable,int id,int status);
    Iterable<Bill>findAllByStatus(int status);
    void save(Bill bill);
    Bill findById(int id);
    Iterable<Bill>findAllUserId(int id);
    Page<Bill> findAllByNameContaining(Pageable pageable, String name);
}