package com.management.hospital.managementhospital.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.management.hospital.managementhospital.models.ProductModel;
import com.management.hospital.managementhospital.repositories.ProductRepository;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean existsByLote(String lote) {
        return productRepository.existsByLote(lote);
    }

    @Transactional
    public Object save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public Page<ProductModel> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<ProductModel> findById(Long id) {
        return productRepository.findById(id);
    }

    public void delete(ProductModel productModel) {
        productRepository.delete(productModel);
    }
    
}
