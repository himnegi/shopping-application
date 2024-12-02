package com.microservices.productservice.model;

import com.microservices.productservice.dto.ProductResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
@Entity
@Table(name = "product")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductResponse mapToProductResponse() {
        return ProductResponse.builder().description(this.getDescription()).id(this.getId()).name(this.getName()).price(this.getPrice()).build();
    }
}
