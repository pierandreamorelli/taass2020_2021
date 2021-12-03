package com.taass.ecommerce.repository;

import com.taass.ecommerce.model.OrderProduct;
import com.taass.ecommerce.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
