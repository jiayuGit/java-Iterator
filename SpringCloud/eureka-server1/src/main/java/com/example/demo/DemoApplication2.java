package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoApplication2 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication2.class);
        springApplication.setAdditionalProfiles("peer2");
        //启动服务器
        springApplication.run(args);
    }
}
