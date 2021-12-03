package com.taass.ecommerce.service;

import com.taass.ecommerce.exception.ResourceNotFoundException;
import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import com.taass.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteAllProducts(){ productRepository.deleteAll(); }

    @Override
    public void deleteProductByID(long id) { productRepository.deleteById(id);}

    @Override
    public Iterable<Product> findByCategory(ProductCategories category) {  return productRepository.findByCategory(category);}

    @Override
    public Iterable<Product> findByRange(double p1, double p2) {  return productRepository.findByRange(p1,p2);}

    @Override
    public Iterable<Product> findByCatRange(double p1, double p2, ProductCategories category) {  return productRepository.findByCatRange(p1,p2, category);}

    @Override
    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
