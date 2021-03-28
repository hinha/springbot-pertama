package com.example.firstspring.demo.service.impl;

import com.example.firstspring.demo.error.NotFoundException;
import com.example.firstspring.demo.validation.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.firstspring.demo.entity.Product;
import com.example.firstspring.demo.model.CreateProductReq;
import com.example.firstspring.demo.model.ProductResponse;
import com.example.firstspring.demo.repository.ProductRepository;
import com.example.firstspring.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    ValidationUtil validationUtil;
    ProductServiceImpl(ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
    }

    @Override
    public ProductResponse create(CreateProductReq createProductReq) {
        validationUtil.validate(createProductReq);

        Product p = new Product(
                createProductReq.name,
                createProductReq.price,
                createProductReq.quantity,
                new Date(),
                new Date()
        );

        productRepository.save(p);
        logger.info("# of cities: {}", productRepository.count());

        return convertProductToResponse(p);
    }

    @Override
    public ProductResponse getId(Long id) throws NotFoundException {
        Optional<Product> p = productRepository.findById(id);

        if (p.orElse(null) == null) {
            throw new NotFoundException();
        } else {
            return convertProductToResponse(p.get());
        }
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    private ProductResponse convertProductToResponse(Product p) {
        return new ProductResponse(
                p.getName(),
                p.getPrice(),
                p.getQuantity(),
                p.getCreatedAt()
        );
    }
}
