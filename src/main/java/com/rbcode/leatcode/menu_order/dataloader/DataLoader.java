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
        itemRepository.save(Item.builder().name("Borscht").description("Traditional sour soup with beans").cost(45.0).build());
        itemRepository.save(Item.builder().name("Tripe Soup").description("Creamy soup with beef tripe and sour cream").cost(52.0).build());
        itemRepository.save(Item.builder().name("Stuffed Cabbage Rolls").description("Cabbage rolls with minced meat and rice").cost(60.0).build());
        itemRepository.save(Item.builder().name("Cheese Pie").description("Baked pie filled with sweet cheese").cost(25.0).build());
        itemRepository.save(Item.builder().name("Roast Pork").description("Oven-roasted pork with potatoes").cost(68.0).build());
        itemRepository.save(Item.builder().name("Fried Chicken").description("Fried chicken with garlic sauce").cost(55.0).build());
        itemRepository.save(Item.builder().name("Polenta with Cheese and Cream").description("Cornmeal with salty cheese and sour cream").cost(35.0).build());
        itemRepository.save(Item.builder().name("Dumplings with Potatoes").description("Boiled dumplings stuffed with mashed potatoes").cost(30.0).build());
        itemRepository.save(Item.builder().name("Grilled Trout").description("Fresh trout grilled with lemon and herbs").cost(70.0).build());
        itemRepository.save(Item.builder().name("Vegetable Stew").description("Hearty stew with mixed vegetables and herbs").cost(40.0).build());
        itemRepository.save(Item.builder().name("Lentil Soup").description("Creamy soup made with red lentils and spices").cost(38.0).build());
        itemRepository.save(Item.builder().name("Beef Goulash").description("Slow-cooked beef stew with paprika").cost(65.0).build());
        itemRepository.save(Item.builder().name("Chicken Schnitzel").description("Breaded and fried chicken cutlet").cost(50.0).build());
        itemRepository.save(Item.builder().name("Pasta Carbonara").description("Creamy pasta with bacon and parmesan").cost(58.0).build());
        itemRepository.save(Item.builder().name("Caesar Salad").description("Romaine lettuce with chicken, croutons, and Caesar dressing").cost(42.0).build());
        itemRepository.save(Item.builder().name("Mushroom Risotto").description("Creamy risotto with mushrooms and parmesan").cost(54.0).build());
        itemRepository.save(Item.builder().name("Grilled Vegetables").description("Assorted grilled seasonal vegetables").cost(33.0).build());
        itemRepository.save(Item.builder().name("Omelette with Ham").description("Fluffy omelette filled with ham and cheese").cost(36.0).build());
        itemRepository.save(Item.builder().name("Beef Burger").description("Juicy beef patty with lettuce, tomato, and cheese").cost(59.0).build());
        itemRepository.save(Item.builder().name("Fish and Chips").description("Fried fish fillet with French fries and tartar sauce").cost(62.0).build());
    }
}
