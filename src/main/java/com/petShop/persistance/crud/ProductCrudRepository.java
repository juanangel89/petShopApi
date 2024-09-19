package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {
}
