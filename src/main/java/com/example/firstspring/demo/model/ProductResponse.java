package com.example.firstspring.demo.model;

import javax.persistence.Column;
import java.util.Date;

public class ProductResponse {
    public String name;
    public Long price;
    public int quantity;
    public Date createdAt;

    public ProductResponse(String name, Long price, int quantity, Date createdAt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }
}
