package com.petShop.domain.service;

import com.petShop.domain.dto.BillDetailDTO;
import com.petShop.domain.repository.BillDetailDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BillDetailService {
    @Autowired
    private BillDetailDomainRepository billDetailDomainRepository; //llamar a petrepositoriy

    public Iterable<BillDetailDTO> getAll() {
        return billDetailDomainRepository.getAll();
    }

    public Optional<BillDetailDTO> getBillDetailById(int id) {return billDetailDomainRepository.getBillDetailById(id);}

    public BillDetailDTO save(BillDetailDTO billDetailDTO){return billDetailDomainRepository.save(billDetailDTO);}

    public BillDetailDTO update(BillDetailDTO billDetailDTO){return billDetailDomainRepository.update(billDetailDTO);}

    public void delete(int id){
        billDetailDomainRepository.delete(id);
    }

    public boolean existsBillDetail(int id) {return billDetailDomainRepository.existsBillDetail(id);}

    public long countAll() {return billDetailDomainRepository.countAll();}
}
