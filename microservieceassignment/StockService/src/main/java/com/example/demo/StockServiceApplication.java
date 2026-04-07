package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Repository.IStockRepository;
import com.example.demo.Stock.Stock;

@SpringBootApplication
public class StockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertFakeData(IStockRepository repo) {
        return args -> {

            Stock s1 = new Stock();
            s1.setProductId(1);
            s1.setQuantity(50);
            s1.setInStock(true);
            repo.save(s1);

            Stock s2 = new Stock();
            s2.setProductId(2);
            s2.setQuantity(20);
            s2.setInStock(true);
            repo.save(s2);

            System.out.println("2 fake stocks inserted!");
        };
    }
}