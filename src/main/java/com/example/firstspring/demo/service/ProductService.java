package com.example.firstspring.demo.service;

import com.example.firstspring.demo.model.CreateProductReq;
import com.example.firstspring.demo.model.ProductResponse;

public interface ProductService {
    ProductResponse create(CreateProductReq createProductReq);
    ProductResponse getId(Long id) throws Exception;
}
