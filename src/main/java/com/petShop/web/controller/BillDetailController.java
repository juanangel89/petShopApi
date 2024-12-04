package com.petShop.web.controller;

import com.petShop.domain.dto.BillDetailDTO;
import com.petShop.domain.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/billDetails")
public class BillDetailController {

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("/getAll")
    public Iterable<BillDetailDTO> getAll() {
        return billDetailService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<BillDetailDTO> getBillDetailById(@PathVariable int id) {
        return billDetailService.getBillDetailById(id);
    }

    @PostMapping("/save")
    public BillDetailDTO save(@RequestBody BillDetailDTO billDetailDTO) {
        return billDetailService.save(billDetailDTO);
    }

    @PutMapping("/update")
    public BillDetailDTO update(@RequestBody BillDetailDTO billDetailDTO) {
        return billDetailService.update(billDetailDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        billDetailService.delete(id);
    }

    @GetMapping("/existsBillDetail/{id}")
    public boolean existsBillDetail(@PathVariable("id") int id) {
        return billDetailService.existsBillDetail(id);
    }

    @GetMapping("/countBillDetails")
    public long countBillDetails() {
        return billDetailService.countAll();
    }
}
