package com.taass.ecommerce.controller;

import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import com.taass.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/test")
    public @NotNull String getProva() {
        return "this is a test";
    }
    @PostMapping ("/products")
    public @NotNull Product putProduct(@RequestBody Product p) {
        return productService.save(p);
    }

    @GetMapping("/products/{category}")
    public @NotNull Iterable<Product> getProductsByCategory(@PathVariable("category")ProductCategories category) {
        return productService.findByCategory(category);
    }
    @GetMapping("/products/{p1}/-/{p2}")
    public @NotNull Iterable<Product> getProductsByRange(@PathVariable("p1")double p1,@PathVariable("p2")double  p2) {
        return productService.findByRange(p1, p2);
    }

    @GetMapping("/products/{category}/{p1}/{p2}")
    public @NotNull Iterable<Product> getProductByCatRange(@PathVariable("p1")double p1,@PathVariable("p2")double  p2,@PathVariable("category")ProductCategories category ) {
        return productService.findByCatRange(p1, p2, category);
    }

    @GetMapping("/products/id/{id}")
    public @NotNull Product getProductsById( @PathVariable("id") long id){
        return productService.getProduct(id);
    }

    @GetMapping("/products/search={name}")
    public @NotNull Iterable<Product> findByName(@PathVariable("name") String name) {
        return productService.findByNameContainingIgnoreCase(name);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        System.out.println("Delete Product with ID = " + id + "...");

        productService.deleteProductByID(id);

        return new ResponseEntity<>("Product has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/products/delete")
    public ResponseEntity<String> deleteAllProducts() {
        System.out.println("Delete All Products...");

        productService.deleteAllProducts();

        return new ResponseEntity<>("All Products have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Product> updateProductByID(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("Update Product with ID = " + id + "...");

        Optional<Product> productData = Optional.ofNullable(productService.getProduct(id));

        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setName(product.getName());
            _product.setPrice(product.getPrice());
            _product.setPictureUrl(product.getPictureUrl());
            _product.setCategory(product.getCategory());
            return new ResponseEntity<>(productService.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
