package com.rbcode.leatcode.menu_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MenuOrderApp {

    public static void main(String[] args) {
        SpringApplication.run(MenuOrderApp.class, args);
    }

}
