package com.tonny.controller;

import com.tonny.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

@Value("${server.port}")
    private  int port =2200;

    @RequestMapping(value = "/{logName}",method = RequestMethod.GET)
    public User getUser(@PathVariable String logName)
    {
        String words ="I come from "+this.port;

        return new User("tonny","1000","38");
    }
}
