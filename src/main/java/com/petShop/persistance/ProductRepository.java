package com.petShop.persistance;

import com.petShop.persistance.crud.ProductCrudRepository;
import com.petShop.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product> getOwnerById(int idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public Product save(Product product){
        return productCrudRepository.save(product);
    }

    public void deleted(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

    public boolean existsProduct(int idProduct){
        return productCrudRepository.existsById(idProduct);
    }

    public long countAll(){
        return productCrudRepository.count();
    }
}