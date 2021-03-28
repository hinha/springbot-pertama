package com.example.firstspring.demo.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateProductReq {

    @NotBlank
    public String name;

    @NotNull
    @Min(value = 1)
    public Long price;

    @NotNull
    @Min(value = 1)
    public int quantity;
}
