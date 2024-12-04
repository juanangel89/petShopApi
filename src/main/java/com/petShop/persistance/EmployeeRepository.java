package com.petShop.persistance;

import com.petShop.domain.dto.EmployeeDTO;
import com.petShop.domain.repository.EmployeeDomainRepository;
import com.petShop.persistance.crud.EmployeeCrudRepository;
import com.petShop.persistance.entity.Employee;
import com.petShop.persistance.mapper.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements EmployeeDomainRepository {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Iterable<EmployeeDTO> getAll() {
        Iterable<Employee> employees = employeeCrudRepository.findAll();
        // Mapeo explícito de cada entidad a DTO
        return ((List<Employee>) employees).stream()
                .map(mapper::toEmployeeDTO) // Mapea cada Pet a PetDTO
                .collect(Collectors.toList());
    }
    @Override
    public Optional<EmployeeDTO> getEmployeeById(int idEmployee){
        Optional<Employee> employee = employeeCrudRepository.findById(idEmployee);
        return employee.map(mapper::toEmployeeDTO);
    }
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO){
        System.out.println("Datos recibidos en DTO: " + employeeDTO);

        Employee employee = mapper.toEntity(employeeDTO);
        System.out.println("Datos mapeados a la entidad: " + employee);

        Integer employeeId = employee.getIdEmployee();

        if (employeeId != null && existsEmployee(employeeId)) {
            throw new IllegalArgumentException("El registro ya existe");
        }
        Employee savedEmployee = employeeCrudRepository.save(employee);
        System.out.println("Datos guardados en la base de datos: " + savedEmployee);
        return mapper.toEmployeeDTO(savedEmployee);
    }

    // Actualizar
    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO){
        System.out.println("Datos recibidos en DTO: " + employeeDTO);

        Employee employee = mapper.toEntity(employeeDTO);
        System.out.println("Datos mapeados a la entidad: " + employee);

        Integer employeeId = employee.getIdEmployee();

        if (!existsEmployee(employeeId)) {
            throw new IllegalArgumentException("El registro  no existe");
        }
        Employee updateEmployee = employeeCrudRepository.save(employee);
        System.out.println("Datos guardados en la base de datos: " + updateEmployee);
        return mapper.toEmployeeDTO(updateEmployee);
    }
    @Override
    public void delete(int idEmployee){
        if (existsEmployee(idEmployee)) {
            employeeCrudRepository.deleteById(idEmployee);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }
    @Override
    public boolean existsEmployee(int idEmployee){
        return employeeCrudRepository.existsById(idEmployee);
    }
    @Override
    public long countAll(){
        return employeeCrudRepository.count();
    }

}