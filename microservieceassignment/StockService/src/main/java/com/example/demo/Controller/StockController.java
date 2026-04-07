package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Stock.Stock;
import com.example.demo.Repository.IStockRepository;

@RestController
public class StockController {

    @Autowired
    IStockRepository repo;

  
    @PostMapping("/stock")
    public Stock addStock(@RequestBody Stock s) {
        return repo.save(s);
    }


    @GetMapping("/stock/{id}")
    public Stock getStockById(@PathVariable int id) {
        return repo.findById(id).get();
    }

    @GetMapping("/stock")
    public List<Stock> getAllStock() {
        return repo.findAll();
    }
}
