package com.example.thuongmaidientu.controller;

import com.example.thuongmaidientu.model.Bill;
import com.example.thuongmaidientu.model.Role;
import com.example.thuongmaidientu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/bill")
public class BillController {
    @Autowired
    private BillService billService;



    //xem đơn hàng đã mua
    @GetMapping("/search-by-status")
    public ResponseEntity<Iterable<Bill>>showBillById(@PageableDefault(size = 5) Pageable pageable,@RequestParam int id, @RequestParam int status)
    {
        Iterable<Bill> bills=billService.findAllByUserIdAndStatus(pageable,id,status);
        if(bills==null)
            return new ResponseEntity<>(bills, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public ResponseEntity<Iterable<Bill>> findAllByNameContaining(@RequestParam String name, @PageableDefault(size = 2) Pageable pageable) {
        return new ResponseEntity<>(billService.findAllByNameContaining(pageable, name), HttpStatus.OK);
    }
    @GetMapping("/order")
    public ResponseEntity<Iterable<Bill>>showBillByStatus(@RequestParam int status)
    {
        Iterable<Bill> bills=billService.findAllByStatus(status);
        if(bills==null)
            return new ResponseEntity<>(bills, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
    @GetMapping("/list-order")
    public ResponseEntity<Iterable<Bill>>getListOrder(@RequestParam int id)
    {
        Iterable<Bill>bills= billService.findAllUserId(id);
        if(bills==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }
    @PostMapping("/confirm")
    public ResponseEntity orderConfirmation(@RequestBody Bill bill)
    {
        billService.save(bill);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}