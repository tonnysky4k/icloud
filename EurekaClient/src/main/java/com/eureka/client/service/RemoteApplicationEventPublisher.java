package com.eureka.client.service;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.context.ApplicationContext;

public class RemoteApplicationEventPublisher {

        public static void publishEvent(RemoteApplicationEvent event){
            ApplicationContext context = ApplicationContextHolder.getApplicationContext();
            if(null != context) {
                context.publishEvent(event);
                System.out.println("已发布事件:{}"+event);
            }else{
                System.out.println("无法获取到当前Spring上下文信息，不能够发布事件");
            }
        }
}
