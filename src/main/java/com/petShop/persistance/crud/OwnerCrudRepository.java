package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerCrudRepository extends CrudRepository<Owner,Integer> {
}
