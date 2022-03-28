package com.eureka.client.service;

import com.eureka.client.entiry.Product;
import com.eureka.client.entiry.ProductMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
   @Autowired
   private Source source;
    private List<Product> productList;

    @Autowired
    public ProductService(Source source)
    {
        this.source=source;
        productList =this.buildProducts();
    }

    public List<Product> findAll()
    {
        return productList;
    }

    public Product findOne(String itemcode)
    {
        for(Product pro:productList)
            if(pro.getId().equals(itemcode))
                return pro;
            return null;
    }

    public Product save(Product product)
    {
        for(Product pro:productList) {
            if (pro.getId().equals(product.getId())) {
                pro.setName("-tonny");
                pro.setNum(pro.getNum() + 100);
                product =pro;
                break;
            }

        }
        sendMsg(ProductMsg.MA_UPDATE, product.getId());
        return  product;
    }

    protected void sendMsg(String msAction,String itemCode)
    {
        ProductMsg productMsg = new ProductMsg(msAction,itemCode);
        source.output().send(MessageBuilder.withPayload(productMsg).build());
    }
/*

    @Autowired
    public ProductService() {
        this.productList = this.buildProducts();
    }

    public Product save(Product product) {
        // TODO: 实现商品保存处理
        for (Product sourceProduct : this.productList) {
            if (sourceProduct.getId().equalsIgnoreCase(product.getId())) {
                sourceProduct.setName(sourceProduct.getName() + "-new");
                sourceProduct.setNum(sourceProduct.getNum() + 100);
                product = sourceProduct;
                break;
            }
        }

        fireEvent(ProductEvent.ET_UPDATE, product);
        return product;
    }

    protected void fireEvent(String eventAction, Product product) {
        ProductEvent productEvent = new ProductEvent(product,
                ApplicationContextHolder.getApplicationContext().getId(), "*:**",
                eventAction, product.getId());
        System.out.println("productEvent="+productEvent);
        RemoteApplicationEventPublisher.publishEvent(productEvent);
    }

 */
    protected List<Product> buildProducts()
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
