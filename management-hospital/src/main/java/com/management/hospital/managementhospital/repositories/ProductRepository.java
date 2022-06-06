package com.management.hospital.managementhospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.hospital.managementhospital.models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

    public boolean existsByLote(String lote);
    
}
