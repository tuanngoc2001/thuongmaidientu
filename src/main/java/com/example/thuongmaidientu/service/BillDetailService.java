package com.example.thuongmaidientu.service;

import com.example.thuongmaidientu.model.BillDetail;

public interface BillDetailService {
    Iterable<BillDetail>findByBillId(int id);
}
