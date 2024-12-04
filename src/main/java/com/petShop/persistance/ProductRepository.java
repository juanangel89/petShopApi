package com.petShop.persistance;

import com.petShop.domain.repository.ProductDomainRepository;
import com.petShop.domain.dto.ProductDTO;
import com.petShop.persistance.crud.ProductCrudRepository;
import com.petShop.persistance.entity.Product;
import com.petShop.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements ProductDomainRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Iterable<ProductDTO> getAll() {
        Iterable<Product> products = productCrudRepository.findAll();
        return ((List<Product>) products).stream()
                .map(mapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(int idProduct) {
        Optional<Product> product = productCrudRepository.findById(idProduct);
        return product.map(mapper::toProductDTO);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        Integer productId = product.getIdProduct();

        if (productId != null && existsProduct(productId)) {
            throw new IllegalArgumentException("El registro ya existe");
        }
        return mapper.toProductDTO(productCrudRepository.save(product));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        Integer productId = product.getIdProduct();

        if (!existsProduct(productId)) {
            throw new IllegalArgumentException("El registro no existe");
        }
        return mapper.toProductDTO(productCrudRepository.save(product));
    }

    @Override
    public void delete(int idProduct) {
        if (existsProduct(idProduct)) {
            productCrudRepository.deleteById(idProduct);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsProduct(int idProduct) {
        return productCrudRepository.existsById(idProduct);
    }

    @Override
    public long countAll() {
        return productCrudRepository.count();
    }
}