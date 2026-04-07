package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.CatalogueService.Product;

public interface IProductRepository extends  JpaRepository<Product, Integer> {
	

}
