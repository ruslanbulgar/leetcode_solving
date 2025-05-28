package com.rbcode.solutions.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondBiggestNumber {
    public static void main(String[] args) {
        final List<Integer> list = List.of(3, 5, 4, 2, 1, 7);

        final Optional<Integer> secondBiggest = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondBiggest.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
    }
}
