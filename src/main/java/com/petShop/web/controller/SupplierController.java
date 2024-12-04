package com.petShop.web.controller;

import com.petShop.domain.dto.SupplierDTO;
import com.petShop.domain.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getAll")
    public Iterable<SupplierDTO> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<SupplierDTO> getSupplierById(@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/save")
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.save(supplierDTO);
    }

    @PutMapping("/update")
    public SupplierDTO update(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.update(supplierDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        supplierService.delete(id);
    }

    @GetMapping("/existsSupplier/{id}")
    public boolean existsSupplier(@PathVariable("id") int id) {
        return supplierService.existsSupplier(id);
    }

    @GetMapping("/countSuppliers")
    public long countSuppliers() {
        return supplierService.countAll();
    }
}