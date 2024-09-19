package com.petShop.persistance;

import com.petShop.persistance.crud.BillCrudRepository;
import com.petShop.persistance.entity.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BillRepository {
    private BillCrudRepository billCrudRepository;

    public List<Bill> getAll(){
        return (List<Bill>) billCrudRepository.findAll();
    }

    public Optional<Bill> getBillById(int idBill){
        return billCrudRepository.findById(idBill);
    }

    public Bill save(Bill bill){
        return billCrudRepository.save(bill);
    }

    public void deleted(int idBill){
        billCrudRepository.deleteById(idBill);
    }

    public boolean existsBill(int idBill){
        return billCrudRepository.existsById(idBill);
    }

    public long countAll(){
        return billCrudRepository.count();
    }
}