package com.petShop.persistance.crud;

import com.petShop.persistance.entity.BillDetail;
import org.springframework.data.repository.CrudRepository;

public interface BillDetailCrudRepository extends CrudRepository<BillDetail,Integer> {
}
