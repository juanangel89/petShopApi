package com.petShop.web.controller;

import com.petShop.domain.dto.EmployeeDTO;
import com.petShop.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public Iterable<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<EmployeeDTO> getOwnerById(@PathVariable("id") int id) { return employeeService.getOwnerById(id);
    }

    @PostMapping("/save")
    public EmployeeDTO save(@RequestBody EmployeeDTO ownerDTO) {
        return employeeService.save(ownerDTO);
    }

    @PutMapping("/update")
    public EmployeeDTO update(@RequestBody EmployeeDTO ownerDTO) {
        return employeeService.update(ownerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @GetMapping("/existsEmployee/{id}")
    public boolean existsEmployee(@PathVariable("id") int id) {
        return employeeService.existsEmployee(id);
    }

    @GetMapping("/countEmployees")
    public long countEmployees() {
        return employeeService.countAll();
    }
}
