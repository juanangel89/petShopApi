package com.petShop.persistance;

import com.petShop.persistance.crud.EmployeeCrudRepository;
import com.petShop.persistance.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class EmployeeRepository {
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> getAll(){
        return (List<Employee>) employeeCrudRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int idEmployee){
        return employeeCrudRepository.findById(idEmployee);
    }

    public Employee save(Employee employee){
        return employeeCrudRepository.save(employee);
    }

    public void deleted(int idEmployee){
        employeeCrudRepository.deleteById(idEmployee);
    }

    public boolean existsEmployee(int idEmployee){
        return employeeCrudRepository.existsById(idEmployee);
    }

    public long countAll(){
        return employeeCrudRepository.count();
    }
}