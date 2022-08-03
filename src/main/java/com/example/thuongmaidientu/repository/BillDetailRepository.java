package com.example.thuongmaidientu.repository;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
    Page<BillDetail>findAllByBillId(Pageable pageable,int id);
    Iterable<BillDetail>findAllByBill_User_Id(int id);

}
