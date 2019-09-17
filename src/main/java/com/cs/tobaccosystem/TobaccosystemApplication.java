package com.cs.tobaccosystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@ServletComponentScan
@SpringBootApplication
@EnableCaching
public class TobaccosystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobaccosystemApplication.class, args);
    }

}
