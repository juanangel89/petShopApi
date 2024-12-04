package com.petShop.domain.repository;

import com.petShop.domain.dto.BillDetailDTO;

import java.util.Optional;

public interface BillDetailDomainRepository {
    Iterable<BillDetailDTO> getAll();
    Optional<BillDetailDTO> getBillDetailById(int idBillDetail);
    BillDetailDTO save(BillDetailDTO billDetailDTO);
    BillDetailDTO update(BillDetailDTO billDetailDTO);
    void delete(int idBillDetail);
    boolean existsBillDetail(int idBillDetail);
    long countAll();
}
