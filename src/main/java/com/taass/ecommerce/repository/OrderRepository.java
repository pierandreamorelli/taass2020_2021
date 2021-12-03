package com.taass.ecommerce.repository;

import com.taass.ecommerce.model.Order;
import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
