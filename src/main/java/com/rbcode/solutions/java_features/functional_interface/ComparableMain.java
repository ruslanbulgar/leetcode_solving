package com.rbcode.solutions.java_features.functional_interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableMain {
    /* It compares two objects for ordering. */
    public static void main(String[] args) {
        List<String> names = List.of("John", "Bob", "Tim", "Fred", "Alice");
        System.out.println("Initial list : " + names);

        List<String> sorted = new ArrayList<>(names);
        sorted.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted Asc list : " + sorted);

        sorted.sort(Comparator.reverseOrder());

        System.out.println("Sorted Desc list : " + sorted);
    }
}
