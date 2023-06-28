package com.rbcode.leatcode.menu_order.repository;

import com.rbcode.leatcode.menu_order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
