package com.api.stockcontrol.services;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product store(Product product) {
        return productRepository.save(product);
    }

}
