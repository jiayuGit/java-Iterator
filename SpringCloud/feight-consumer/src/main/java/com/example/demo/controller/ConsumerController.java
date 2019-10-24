package com.example.demo.controller;

import com.example.demo.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
//    @HystrixCommand(fallbackMethod="error")
    @RequestMapping(value = "feign-consumer",method=RequestMethod.PUT)
    public String helloConsumer(Integer id,String name){
        return helloService.hello(id,name
        );
    }
    public String error(){
        return "error";
    }
}
