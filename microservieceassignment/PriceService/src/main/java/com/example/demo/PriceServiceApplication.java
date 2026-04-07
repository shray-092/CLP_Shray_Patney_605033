package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Repository.IPriceRepository;
import com.example.demo.price.Price;

@SpringBootApplication
public class PriceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertFakeData(IPriceRepository repo) {
        return args -> {

            Price p1 = new Price();
            p1.setProductId(1);
            p1.setAmount(75000.00);
            p1.setCurrency("INR");
            repo.save(p1);

            Price p2 = new Price();
            p2.setProductId(2);
            p2.setAmount(25000.00);
            p2.setCurrency("INR");
            repo.save(p2);

            System.out.println("2 fake prices inserted!");
        };
    }
}