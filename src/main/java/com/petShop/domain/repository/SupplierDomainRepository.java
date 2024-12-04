package com.petShop.domain.repository;

import com.petShop.domain.dto.SupplierDTO;

import java.util.Optional;

public interface SupplierDomainRepository {
    Iterable<SupplierDTO> getAll();
    Optional<SupplierDTO> getSupplierById(int idSupplier);
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO update(SupplierDTO supplierDTO);
    void delete(int idSupplier);
    boolean existsSupplier(int idSupplier);
    long countAll();
}
