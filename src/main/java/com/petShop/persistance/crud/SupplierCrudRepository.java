package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierCrudRepository extends CrudRepository<Supplier,Integer> {
}
