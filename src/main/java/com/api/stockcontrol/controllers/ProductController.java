package com.api.stockcontrol.controllers;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product store(@RequestBody Product product) {
        return this.productService.store(product);
    }

}
