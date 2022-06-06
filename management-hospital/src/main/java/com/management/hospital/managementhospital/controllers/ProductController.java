package com.management.hospital.managementhospital.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.hospital.managementhospital.dtos.ProductDto;
import com.management.hospital.managementhospital.models.ProductModel;
import com.management.hospital.managementhospital.services.ProductService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDto productDto){
        
        if(productService.existsByLote(productDto.getLote())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Lote is already in use");
        }
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);
        productModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productModel));
    }

    @GetMapping
    public ResponseEntity<Page<ProductModel>> getAllProducts(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getOnePacient(@PathVariable(value = "id") Long id) {
        Optional<ProductModel> productModelOptional = productService.findById(id);
        if (!productModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Object> updateRoom(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductDto productDto) {
        Optional<ProductModel> productModelOptional = productService.findById(id);
        if (!productModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);
        productModel.setId(productModelOptional.get().getId());
        productModel.setRegistrationDate(productModelOptional.get().getRegistrationDate());
        productModel.setLote(productModelOptional.get().getLote());
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable(value = "id") Long id) {
        Optional<ProductModel> roomModelOptional = productService.findById(id);
        if (!roomModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productService.delete(roomModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
    
}
