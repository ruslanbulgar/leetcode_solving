package com.rbcode.solutions.composite_pattern.order;

public class Order {
    public static void main(String[] args) {
        Box order = new Box("Order");

        order.addItem(new Product(300, "SmartPhone"));
        order.addItem(createSmallerBox());
        order.addItem(new Product(500, "Electric drill"));

        System.out.println(order);
        System.out.println("Total price: " + order.getPrice());
        ;
    }

    private static Item createSmallerBox() {
        Box box = new Box("Smaller Box 1");
        box.addItem(new Product(23, "Headphones"));
        box.addItem(new Product(5, "Screen Protector"));
        box.addItem(new Product(10, "Huse"));
        box.addItem(createEvenSmallerBox());
        return box;
    }

    private static Item createEvenSmallerBox() {
        Box box = new Box("Even smaller box");
        box.addItem(new Product(52, "Cip1"));
        box.addItem(new Product(49, "Cip2"));
        return box;
    }
}
