package com.consumer.service;

import com.consumer.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductServiceFallBack implements ProductService{

    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Product getProductDetails(String itemcode) {
        return new Product();
    }
}
