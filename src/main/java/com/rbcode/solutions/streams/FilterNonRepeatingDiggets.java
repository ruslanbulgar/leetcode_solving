package com.rbcode.solutions.streams;

import java.util.Arrays;
import java.util.List;

public class FilterNonRepeatingDiggets {

    /*i have a list of numbers 98, 99, 100, 101, 102, 103, for example.
    return only those which do not have repeating digits in it.
    for example, 99 won't be returned since 9 is used twice there,
    100 won't be returneed sinze there are two 0, 101 as well, since digit 1 repeats. */

    public static void main(String[] args) {
        final List<Integer> list = List.of(98, 99, 100, 101, 102, 103);

        list.stream()
                .filter(FilterNonRepeatingDiggets::doesNotHaveRepeatingDigits).toList()
                .forEach(System.out::println);
    }

    private static boolean doesNotHaveRepeatingDigits(Integer n) {
        int[] digits = String.valueOf(Math.abs(n)).chars().map(c -> c - '0').toArray();

        return Arrays.stream(digits).distinct().count() == digits.length;
    }
}
