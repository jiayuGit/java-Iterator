package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class HelloServiceImp implements HelloService{
    @Override
    public String hello(Integer id, String name) {

        System.out.println("溶短");
        return "error"+id+name;
    }
}
