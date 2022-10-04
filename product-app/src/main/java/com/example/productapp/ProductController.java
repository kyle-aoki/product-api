package com.example.productapp;

import org.example.CreateProductInput;
import org.example.CreateProductOutput;
import org.example.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductInterface {

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;

    @RequestMapping("/create/product")
    public CreateProductOutput createProduct(@RequestBody CreateProductInput createProductInput) {
        return productService.createProduct(createProductInput);
    }
}
