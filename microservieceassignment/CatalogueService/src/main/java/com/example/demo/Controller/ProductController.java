package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CatalogueService.Product;
import com.example.demo.Repository.IProductRepository;


@RestController
public class ProductController {
	@Autowired
	IProductRepository repo;
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductByID(@PathVariable int id) {
		return repo.findById(id).orElse(null);
		
	}
	@PostMapping("/products")
		public Product addProduct(@RequestBody Product product) {
			return repo.save(product);
		}
	
}
