package com.rbcode.leatcode.menu_order.repository;

import com.rbcode.leatcode.menu_order.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
