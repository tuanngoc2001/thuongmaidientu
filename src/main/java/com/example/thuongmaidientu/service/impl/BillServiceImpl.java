package com.example.thuongmaidientu.service.impl;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.Role;
import com.example.thuongmaidientu.repository.BillRepository;
import com.example.thuongmaidientu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository repository;
    @Override
    public Page<Bill> findAllByUserIdAndStatus(Pageable pageable,int id,int status) {
        return repository.findAllByUserIdAndStatus(pageable,id,status);
    }
    @Override
    public Iterable<Bill> findAllByStatus(int status) {
        return repository.findAllByStatus(status);
    }

    @Override
    public void save(Bill bill) {
        repository.save(bill);
    }

    @Override
    public Bill findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Bill> findAllUserId(int id) {
        return repository.findAllByUserId(id);
    }
    @Override
    public Page<Bill> findAllByNameContaining(Pageable pageable, String name) {
        return repository.findAllByNameContaining(pageable,name);
    }
}
