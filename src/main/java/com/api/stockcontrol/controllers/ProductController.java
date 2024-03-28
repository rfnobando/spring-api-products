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


@RestController
@CrossOrigin(origins = "*")
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
    public Product show(@PathVariable Long id) {
        return this.productService.show(id);
    }

    @PutMapping(path = "/{id}")
    public Product update(@RequestBody Product request, @PathVariable Long id) {
        return this.productService.update(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        productService.delete(id);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "200");
        responseBody.put("message", "El producto fue eliminado con éxito.");

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "404");
        responseBody.put("message", "El producto no existe.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

}
