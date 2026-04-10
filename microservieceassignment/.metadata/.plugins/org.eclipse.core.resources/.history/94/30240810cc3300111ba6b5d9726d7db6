package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.CartProduct.CartProduct;
import com.example.demo.CartProduct.Price;
import com.example.demo.CartProduct.Product;
import com.example.demo.CartProduct.Recommendation;
import com.example.demo.CartProduct.Stock;

@RestController
public class CartController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/cart/{id}")
    public CartProduct getCartProduct(@PathVariable int id) {

      
        Product product = restTemplate.getForObject(
            "http://CATALOGUESERVICE/products/" + id,
            Product.class
        );

        Price price = restTemplate.getForObject(
            "http://PRICESERVICE/price/" + id,
            Price.class
        );

        Stock stock = restTemplate.getForObject(
            "http://STOCKSERVICE/stock/" + id,
            Stock.class
        );

        Recommendation rec = restTemplate.getForObject(
            "http://RECOMMENDATIONSERVICE/recommendations/" + id,
            Recommendation.class
        );

        CartProduct cp = new CartProduct();
        cp.setId(id);
        cp.setName(product.getName());
        cp.setCategory(product.getCategory());
        cp.setDescription(product.getDescription());
        cp.setAmount(price.getAmount());
        cp.setCurrency(price.getCurrency());
        cp.setQuantity(stock.getQuantity());
        cp.setInStock(stock.isInStock());
        cp.setRecommendedProducts(rec.getRecommendedProducts());

        return cp;
    }
}