package com.consumer.controller;


import com.consumer.entity.Product;
import com.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class MallController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getList()
    {
        return productService.findAll();
    }

    @RequestMapping(value = "/{itemcode}",method = RequestMethod.GET)
    Product getProDedetail(@PathVariable("itemcode") String itemcode)
    {
        return productService.getProductDetails(itemcode);
    }
}
