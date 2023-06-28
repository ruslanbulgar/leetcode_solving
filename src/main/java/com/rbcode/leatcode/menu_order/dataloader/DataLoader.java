package com.rbcode.leatcode.menu_order.dataloader;

import com.rbcode.leatcode.menu_order.model.Item;
import com.rbcode.leatcode.menu_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Transactional
    @Override
    public void run(String... args) {
        itemRepository.save(Item.builder().name("Bors").description("Bors cu fasole").cost(45.0).build());
        itemRepository.save(Item.builder().name("Mamaliga").description("Mamaliga cu branza").cost(65.0).build());
        itemRepository.save(Item.builder().name("Pizza 1").description("Ciuperci sos de rosii").cost(95.0).build());
        itemRepository.save(Item.builder().name("Pizza 2").description("4 cascavaluri").cost(85.0).build());
    }
}
