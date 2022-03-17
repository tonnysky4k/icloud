package com.eureka.client.controller;


import com.eureka.client.entiry.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @RequestMapping(method = RequestMethod.GET)
  List<Product> getList()
  {

      return buildProduc();
  }

  @RequestMapping(value = "/{itemcode}" ,method = RequestMethod.GET)
  Product getProductDetails(@PathVariable("itemcode") String itemcode)
  {
      System.out.println("itemcode="+itemcode);
        List<Product> products =buildProduc();
        for(Product product :products)
            if(product.getId().equals(itemcode))
                return product;

            return null;

  }
    protected List<Product> buildProduc()
    {
        List<Product> al = new ArrayList<>();
        for(int i =0;i<7;i++)
        {
            Product p = new Product();
            p.setId("item"+i);
            p.setName("贵金属"+i);
            p.setDesc("有色金属");
            p.setNum(i*100);
            al .add(p);
        }
        return al;

    }
}
