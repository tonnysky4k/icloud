package com.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloController {


    protected Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    @Qualifier(value="restTemplate")
    private RestTemplate restTemplate;


    @Autowired
    @Qualifier(value = "lbcRestTemplate")
    private RestTemplate lbcRestTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String say()
    {

        return restTemplate.getForEntity("http://service-hello/hello",String.class).getBody();
    }

    @RequestMapping(value = "/helloEx",method = RequestMethod.GET)
    public String sayEx()
    {

        ServiceInstance serviceInstance =this.loadBalancerClient.choose("service-hello");
        URI hellUri = URI.create(String.format("http://%s:%s/hello",serviceInstance.getHost(),serviceInstance.getPort()));
        logger.info("Target service uri = {}. ", hellUri.toString());
        return this.lbcRestTemplate.getForEntity(hellUri, String.class).getBody();
    }
}
