package com.taass.ecommerce.repository;

import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.category = :category")
    List<Product> findByCategory(@Param("category") ProductCategories category);

    @Query("select p from Product p where p.price > :p1 AND p.price < :p2")
    List<Product> findByRange(@Param("p1") double p1, @Param("p2") double p2);

    @Query("select p from Product p where p.price > :p1 AND p.price < :p2 AND p.category = :category")
    List<Product> findByCatRange(@Param("p1") double p1, @Param("p2") double p2, @Param("category") ProductCategories category);

    List<Product> findByNameContainingIgnoreCase(String name);
}
