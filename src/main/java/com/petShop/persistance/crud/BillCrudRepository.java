package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillCrudRepository extends CrudRepository<Bill,Integer> {
}
