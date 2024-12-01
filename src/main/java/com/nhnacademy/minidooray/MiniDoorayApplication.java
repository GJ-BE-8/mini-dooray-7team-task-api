package com.nhnacademy.minidooray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MiniDoorayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniDoorayApplication.class, args);
    }
}
