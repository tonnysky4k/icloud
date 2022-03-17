package com.consumer.service;


import com.consumer.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="PRODUCT-SERVICE",fallback = ProductServiceFallBack.class)
public interface ProductService {

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    List<Product> findAll();

    @RequestMapping(value = "/products/{itemcode}",method = RequestMethod.GET)
    Product getProductDetails(@PathVariable("itemcode") String itemcode);

}
