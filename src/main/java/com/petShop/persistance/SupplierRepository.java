package com.petShop.persistance;

import com.petShop.domain.dto.SupplierDTO;
import com.petShop.domain.repository.SupplierDomainRepository;
import com.petShop.persistance.crud.SupplierCrudRepository;
import com.petShop.persistance.entity.Supplier;
import com.petShop.persistance.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SupplierRepository implements SupplierDomainRepository {
    @Autowired
    private SupplierCrudRepository supplierCrudRepository;

    @Autowired
    private SupplierMapper mapper;

    @Override
    public Iterable<SupplierDTO> getAll() {
        Iterable<Supplier> suppliers = supplierCrudRepository.findAll();
        return ((List<Supplier>) suppliers).stream()
                .map(mapper::toSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierDTO> getSupplierById(int idSupplier) {
        return supplierCrudRepository.findById(idSupplier)
                .map(mapper::toSupplierDTO);
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        Supplier supplier = mapper.toEntity(supplierDTO);
        return mapper.toSupplierDTO(supplierCrudRepository.save(supplier));
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO) {
        Supplier supplier = mapper.toEntity(supplierDTO);
        if (!supplierCrudRepository.existsById(supplier.getIdSupplier())) {
            throw new IllegalArgumentException("El proveedor no existe.");
        }
        return mapper.toSupplierDTO(supplierCrudRepository.save(supplier));
    }

    @Override
    public void delete(int idSupplier) {
        if (supplierCrudRepository.existsById(idSupplier)) {
            supplierCrudRepository.deleteById(idSupplier);
        } else {
            throw new IllegalArgumentException("El proveedor no existe.");
        }
    }

    @Override
    public boolean existsSupplier(int idSupplier) {
        return supplierCrudRepository.existsById(idSupplier);
    }

    @Override
    public long countAll() {
        return supplierCrudRepository.count();
    }
}