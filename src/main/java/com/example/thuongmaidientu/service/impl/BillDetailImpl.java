package com.example.thuongmaidientu.service.impl;

import com.example.thuongmaidientu.model.BillDetail;
import com.example.thuongmaidientu.repository.BillDetailRepository;
import com.example.thuongmaidientu.repository.BillRepository;
import com.example.thuongmaidientu.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillDetailImpl implements BillDetailService {
    @Autowired
    private BillDetailRepository repository;
    @Override
    public Page<BillDetail> findByBillId(Pageable pageable, int id) {
        return repository.findAllByBillId(pageable,id);
    }

    @Override
    public Iterable<BillDetail> findAllByBill_User_Id(int id) {
        return repository.findAllByBill_User_Id(id);
    }
}