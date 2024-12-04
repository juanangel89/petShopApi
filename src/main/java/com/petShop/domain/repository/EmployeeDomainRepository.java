package com.petShop.domain.repository;

import com.petShop.domain.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeDomainRepository {
    Iterable<EmployeeDTO> getAll();
    Optional<EmployeeDTO> getEmployeeById(int idEmployee);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    void delete(int idEmployee);
    boolean existsEmployee(int idEmployee);
    long countAll();
}
