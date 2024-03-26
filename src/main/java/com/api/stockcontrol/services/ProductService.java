package com.api.stockcontrol.services;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> index(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product store(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> show(Long id) {
        return productRepository.findById(id);
    }

}
