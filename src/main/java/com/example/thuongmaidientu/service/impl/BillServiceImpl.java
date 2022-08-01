package com.example.thuongmaidientu.service.impl;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.repository.BillRepository;
import com.example.thuongmaidientu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository repository;
    @Override
    public Iterable<Bill> findAllByUserId(int id,int status) {
        return repository.findAllByUserIdAndStatus(id,status);
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
}
