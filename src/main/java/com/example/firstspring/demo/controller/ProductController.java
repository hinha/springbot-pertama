package com.example.firstspring.demo.controller;

import com.example.firstspring.demo.model.CreateProductReq;
import com.example.firstspring.demo.model.ProductResponse;
import com.example.firstspring.demo.model.Response;
import com.example.firstspring.demo.service.ProductService;
import com.example.firstspring.demo.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(
            value = {"/api/products"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    Response<ProductResponse> createProduct(@RequestBody CreateProductReq body) {
        ProductResponse p = productService.create(body);
        return new Response<>(200, "OK", p);
    }

    @GetMapping(
            value = {"/api/products/{idProduct}"},
            produces = {"application/json"}
    )
    Response<ProductResponse> getProduct(@PathVariable("idProduct") Long id) throws Exception {
        ProductResponse p = productService.getId(id);
        return new Response<>(200, "OK", p);
    }
}
