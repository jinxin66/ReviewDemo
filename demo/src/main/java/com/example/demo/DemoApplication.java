package com.example.demo;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public Redisson redisson(){
//        Config config = new Config();
//        config.useSingleServer("redis://localhost:6379").setAddress(redisUrl).setDatabase(0);
//        return Redisson.create(config);
//    }

}
