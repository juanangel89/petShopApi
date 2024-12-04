package com.petShop.domain.service;

import com.petShop.domain.dto.SupplierDTO;
import com.petShop.domain.repository.SupplierDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierDomainRepository supplierDomainRepository;

    public Iterable<SupplierDTO> getAll() {
        return supplierDomainRepository.getAll();
    }

    public Optional<SupplierDTO> getSupplierById(int idSupplier) {
        return supplierDomainRepository.getSupplierById(idSupplier);
    }

    public SupplierDTO save(SupplierDTO supplierDTO) {
        return supplierDomainRepository.save(supplierDTO);
    }

    public SupplierDTO update(SupplierDTO supplierDTO) {
        return supplierDomainRepository.update(supplierDTO);
    }

    public void delete(int idSupplier) {
        supplierDomainRepository.delete(idSupplier);
    }

    public boolean existsSupplier(int idSupplier) {
        return supplierDomainRepository.existsSupplier(idSupplier);
    }

    public long countAll() {
        return supplierDomainRepository.countAll();
    }
}