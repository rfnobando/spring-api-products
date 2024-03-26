package com.api.stockcontrol.controllers;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Page<Product> index(Pageable pageable) {
        return this.productService.index(pageable);
    }

    @PostMapping
    public Product store(@RequestBody Product product) {
        return this.productService.store(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> show(@PathVariable Long id) {
        return this.productService.show(id);
    }
}
