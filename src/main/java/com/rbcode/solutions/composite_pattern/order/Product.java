package com.rbcode.solutions.composite_pattern.order;

import com.rbcode.solutions.composite_pattern.order.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements Item {

    private int price;

    private String name;

    @Override
    public String toString() {
        return name + " : " + price;
    }
}
