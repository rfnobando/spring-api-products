package com.api.stockcontrol.controllers;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
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

    @PutMapping(path = "/{id}")
    public Product update(@RequestBody Product request, @PathVariable Long id) {
        return this.productService.update(request, id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "404");
        responseBody.put("message", "El producto que intenta actualizar no existe.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

}
