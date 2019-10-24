package com.example.demo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "hello-service",configuration = FeignClientsConfiguration.class, fallbackFactory = HelloServiceFallback.class//,path = "/service"
)
public interface HelloService {

    @Headers("Content-Type: application/json")
    @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    public String hello(@RequestParam("id")Integer id, @RequestParam("name")String name
    );

}
