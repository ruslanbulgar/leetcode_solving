package com.rbcode.solutions.java_features.records;

public class RecordsMainClass {

    public static void main(String[] args) {
        Product product = new Product(1L , "Cup", "Drinking cup, for watter or coffee", 10.0, 1000);

        System.out.println(product.description());
    }
}
