package com.api.stockcontrol.services;

import com.api.stockcontrol.models.Product;
import com.api.stockcontrol.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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

    public Product update(Product request, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        productRepository.save(product);

        return product;
    }

    public void delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }

}
