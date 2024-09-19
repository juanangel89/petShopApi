package com.petShop.persistance;

import com.petShop.persistance.crud.BillDetailCrudRepository;
import com.petShop.persistance.entity.BillDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BillDetailRepository {
    private BillDetailCrudRepository billDetailCrudRepository;

    public List<BillDetail> getAll(){
        return (List<BillDetail>) billDetailCrudRepository.findAll();
    }

    public Optional<BillDetail> getBillDetailById(int idDetailBill){
        return billDetailCrudRepository.findById(idDetailBill);
    }

    public BillDetail save(BillDetail billDetail){
        return billDetailCrudRepository.save(billDetail);
    }

    public void deleted(int idDetailBill){
        billDetailCrudRepository.deleteById(idDetailBill);
    }

    public boolean existsBillDetail(int idDetailBill){
        return billDetailCrudRepository.existsById(idDetailBill);
    }

    public long countAll(){
        return billDetailCrudRepository.count();
    }
}
