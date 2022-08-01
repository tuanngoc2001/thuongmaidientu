package com.example.thuongmaidientu.service;

import com.example.thuongmaidientu.model.Bill;



public interface BillService {

    Iterable<Bill>findAllByUserId(int id,int status);
    Iterable<Bill>findAllByStatus(int status);
    void save(Bill bill);
    Bill findById(int id);
    Iterable<Bill>findAllUserId(int id);
}
