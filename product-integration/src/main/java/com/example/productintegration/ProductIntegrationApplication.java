package com.example.productintegration;

import org.example.CreateProductInput;
import org.example.CreateProductOutput;
import org.example.ProductSdk;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductIntegrationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ProductSdk productSdk = new ProductSdk();
        CreateProductOutput cpo = productSdk.createProduct(new CreateProductInput("car"));
        System.out.println(cpo.name());
    }
}
