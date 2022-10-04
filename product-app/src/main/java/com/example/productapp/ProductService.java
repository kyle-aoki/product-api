package com.example.productapp;

import org.example.CreateProductInput;
import org.example.CreateProductOutput;
import org.example.ProductInterface;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductInterface {
    public CreateProductOutput createProduct(CreateProductInput createProductInput) {
        return new CreateProductOutput(createProductInput.name());
    }
}
