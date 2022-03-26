package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableEurekaClient
@EnableBinding(Source.class)
@SpringBootApplication
public class EurekaClientApplication {
    public  static void main(String[] args)
    {
        SpringApplication.run(EurekaClientApplication.class,args);
    }


}
