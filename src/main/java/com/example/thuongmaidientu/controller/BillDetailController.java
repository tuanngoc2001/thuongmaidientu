package com.example.thuongmaidientu.controller;

import com.example.thuongmaidientu.model.BillDetail;
import com.example.thuongmaidientu.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/billdetails")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    @GetMapping
    public ResponseEntity<Iterable<BillDetail>> showBillDetailById(@RequestParam int id)
    {
        Iterable<BillDetail> billDetails=billDetailService.findByBillId(id);
        if(billDetails==null)
            return new ResponseEntity<>(billDetails, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(billDetails, HttpStatus.OK);
    }
}
