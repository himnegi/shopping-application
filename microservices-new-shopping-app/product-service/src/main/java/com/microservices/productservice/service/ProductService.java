package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = productRequest.toModel();
        productRepository.save(product);
        log.info("Product {} , {} is saved",product.getId(),product.getName());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(Product::mapToProductResponse).toList();
    }


}
