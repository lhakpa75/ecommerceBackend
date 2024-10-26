package com.lhakpa.ecommerce.Services;

import com.lhakpa.ecommerce.Entity.Product;
import com.lhakpa.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

    public abstract Optional<Product> findById(Long id);

    public abstract Optional<Product> findByName(String name);

    public abstract Product updateProduct(Product product);

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public abstract Product createProduct(Product product);

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

