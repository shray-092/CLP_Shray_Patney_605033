package com.example.demo.CartProduct;


import java.util.List;

public class CartProduct {

    private int id;
    private String name;
    private String category;
    private String description;
    private double amount;
    private String currency;
    private int quantity;
    private boolean inStock;
    private List<String> recommendedProducts;
    private String message;  // ← ADDED

    public CartProduct() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isInStock() { return inStock; }
    public void setInStock(boolean inStock) { this.inStock = inStock; }

    public List<String> getRecommendedProducts() { return recommendedProducts; }
    public void setRecommendedProducts(List<String> r) { this.recommendedProducts = r; }

    public String getMessage() { return message; }   // ← ADDED
    public void setMessage(String message) { this.message = message; }  // ← ADDED
}