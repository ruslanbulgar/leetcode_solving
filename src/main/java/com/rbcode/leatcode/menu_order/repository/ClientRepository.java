package com.rbcode.leatcode.menu_order.repository;

import com.rbcode.leatcode.menu_order.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
