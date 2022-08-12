package com.example.thuongmaidientu.service;

import com.example.thuongmaidientu.model.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BillDetailService {
    Page<BillDetail> findByBillId(Pageable pageable, int id);
    Iterable<BillDetail>findAllByBill_User_Id(int id);
}