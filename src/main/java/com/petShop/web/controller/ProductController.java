package com.petShop.web.controller;

import com.petShop.domain.dto.ProductDTO;
import com.petShop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public Iterable<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable("id") int id) { return productService.getProductById(id);}

    @PostMapping("/save")
    public ProductDTO save(@RequestBody ProductDTO productDTO) {return productService.save(productDTO);}

    @PutMapping("/update")
    public ProductDTO update(@RequestBody ProductDTO productDTO) {return productService.update(productDTO);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }

    @GetMapping("/existsAppointment/{id}")
    public boolean existsProduct(@PathVariable("id") int id) {
        return productService.existsAppointment(id);
    }

    @GetMapping("/countProducts")
    public long countProducts() {
        return productService.countAll();
    }
}
