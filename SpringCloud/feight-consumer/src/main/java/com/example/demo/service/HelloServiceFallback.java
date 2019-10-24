package com.example.demo.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello(Integer id, String name) {
                System.out.println("溶短");
                return "Fallback "+id+ " "+name;
            }
        };
    }
}
