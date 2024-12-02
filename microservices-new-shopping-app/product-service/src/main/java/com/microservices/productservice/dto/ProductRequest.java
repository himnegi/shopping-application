package com.microservices.productservice.dto;

import com.microservices.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private String desciption;
    private BigDecimal price;

    public Product toModel(){
        return Product.builder().description(this.desciption).name(this.name).price(this.price).build();
    }
}


