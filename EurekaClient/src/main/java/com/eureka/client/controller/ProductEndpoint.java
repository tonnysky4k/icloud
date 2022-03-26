package com.eureka.client.controller;


import com.eureka.client.entiry.Product;
import com.eureka.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pro")
public class ProductEndpoint {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.POST)
    public Product save(@PathVariable String itemCode) {

        Product product =productService.findOne(itemCode);
        if(null != product)
            productService.save(product);
        return product;
    }
}
