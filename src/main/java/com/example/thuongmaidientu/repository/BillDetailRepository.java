package com.example.thuongmaidientu.repository;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
    Iterable<BillDetail>findAllByBillId(int id);
}
