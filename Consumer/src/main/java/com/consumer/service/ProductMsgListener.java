package com.consumer.service;

import com.consumer.entity.Product;
import com.consumer.entity.ProductMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
@Component
public class ProductMsgListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @StreamListener(Sink.INPUT)
    public void onProductMsg(ProductMsg productMsg) {

        System.out.println("收到商品变更消息，商品货号: {}"+productMsg.getItemCode());
        if (ProductMsg.MA_UPDATE.equalsIgnoreCase(productMsg.getAction())) {

            // 重新获取该商品信息
        } else if (ProductMsg.MA_DELETE.equalsIgnoreCase(productMsg.getAction())) {
            this.logger.debug("收到商品删除消息，所要删除商品货号为: {}", productMsg.getItemCode());
        } else {
            this.logger.debug("收到未知商品消息: {}", productMsg);
        }
    }
 /*
    public void onApplicationEvent(ProductEvent productEvent) {
        System.out.println("收到商品变更消息，商品货号: {}"+productEvent.getItemCode());
        if (ProductEvent.ET_UPDATE.equalsIgnoreCase(productEvent.getAction())) {
            this.logger.debug("Web微服务收到商品变更事件，商品货号: {}", productEvent.getItemCode());
            // 重新获取该商品信息
            System.out.println("收到商品变更消息，商品货号: {}"+productEvent.getItemCode());

        } else if (ProductEvent.ET_DELETE.equalsIgnoreCase(productEvent.getAction())) {
            this.logger.debug("Web微服务收到商品删除事件，所要删除商品货号为: {}", productEvent.getItemCode());
        } else {
            this.logger.debug("Web微服务收到未知商品事件: {}", productEvent);
        }
    }*/
}
