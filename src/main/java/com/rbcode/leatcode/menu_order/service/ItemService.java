package com.rbcode.leatcode.menu_order.service;

import com.rbcode.leatcode.menu_order.model.Item;
import com.rbcode.leatcode.menu_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void addItem(String name, String description, Integer cost) {

        itemRepository.save(Item.builder().name(name).build());
    }
}
