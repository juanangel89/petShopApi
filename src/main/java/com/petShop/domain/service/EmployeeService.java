package com.petShop.domain.service;

import com.petShop.domain.dto.EmployeeDTO;
import com.petShop.domain.repository.EmployeeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDomainRepository employeeDomainRepository; //llamar a petrepositoriy

    public Iterable<EmployeeDTO> getAll() {
        return employeeDomainRepository.getAll();
    }

    public Optional<EmployeeDTO> getOwnerById(int id) {return employeeDomainRepository.getEmployeeById(id);}

    public EmployeeDTO save(EmployeeDTO employeeDTO){return employeeDomainRepository.save(employeeDTO);}

    public EmployeeDTO update(EmployeeDTO employeeDTO){return employeeDomainRepository.update(employeeDTO);}

    public void delete(int id){
        employeeDomainRepository.delete(id);
    }

    public boolean existsEmployee(int id) {return employeeDomainRepository.existsEmployee(id);}

    public long countAll() {return employeeDomainRepository.countAll();}
}
