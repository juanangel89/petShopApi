package com.petShop.domain.repository;

import com.petShop.domain.dto.ProductDTO;

import java.util.Optional;

public interface ProductDomainRepository {
    Iterable<ProductDTO> getAll();
    Optional<ProductDTO> getProductById(int idProduct);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    void delete(int idProduct);
    boolean existsProduct(int idProduct);
    long countAll();
}
