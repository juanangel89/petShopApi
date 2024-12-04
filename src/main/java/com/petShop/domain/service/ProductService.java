package com.petShop.domain.service;

import com.petShop.domain.dto.ProductDTO;
import com.petShop.domain.repository.ProductDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductDomainRepository productDomainRepository; //llamar a petrepositoriy

    public Iterable<ProductDTO> getAll() {
        return productDomainRepository.getAll();
    }

    public Optional<ProductDTO> getProductById(int id) {return productDomainRepository.getProductById(id);}

    public ProductDTO save(ProductDTO productDTO){return productDomainRepository.save(productDTO);}

    public ProductDTO update(ProductDTO productDTO){return productDomainRepository.update(productDTO);}

    public void delete(int id){
        productDomainRepository.delete(id);
    }

    public boolean existsAppointment(int id) {return productDomainRepository.existsProduct(id);}

    public long countAll() {return productDomainRepository.countAll();}
}
