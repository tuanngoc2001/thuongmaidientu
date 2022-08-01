package com.example.thuongmaidientu.service.impl;

import com.example.thuongmaidientu.model.BillDetail;
import com.example.thuongmaidientu.repository.BillDetailRepository;
import com.example.thuongmaidientu.repository.BillRepository;
import com.example.thuongmaidientu.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailImpl implements BillDetailService {
    @Autowired
    private BillDetailRepository repository;
    @Override
    public Iterable<BillDetail> findByBillId(int id) {
        return repository.findAllByBillId(id);
    }
}
