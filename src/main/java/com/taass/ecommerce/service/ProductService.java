package com.taass.ecommerce.service;

import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    void deleteAllProducts();
    void deleteProductByID(long id);

    Iterable<Product> findByCategory(ProductCategories category);

    Iterable<Product> findByRange(double p1, double p2);

    Iterable<Product> findByCatRange(double p1, double p2, ProductCategories category);

    Iterable<Product> findByNameContainingIgnoreCase(String name);


    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

}
