package com.Nil.Electronic.Shop;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
        System.out.println("welcome to codit");
    }

}
