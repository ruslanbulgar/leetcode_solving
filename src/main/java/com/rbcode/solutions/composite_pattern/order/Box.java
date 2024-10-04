package com.rbcode.solutions.composite_pattern.order;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Box implements Item {
    private List<Item> items = new ArrayList<>();
    private final String name;

    @Override
    public int getPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        return "Box : " + name + " contains : \n" + items.stream().map(Object::toString).collect(Collectors.joining("\n" ));
    }
}
