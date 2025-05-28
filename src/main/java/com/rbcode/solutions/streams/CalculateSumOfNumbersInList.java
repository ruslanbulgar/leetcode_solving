package com.rbcode.solutions.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateSumOfNumbersInList {
    /* primesti numeri ca string ("1", "123") trebuie sa returnezi suma lor ca string
        trebuie sa adaugi un cache mechanism - deci cand vine "1", "123" - sa faci cumva storage
        si daca mai vine odata - sa nu calculezi, dar sa scoti din cache
        "1", "123" si "123", "1" - have same result - manage your cache to be smart and figure this out
    */
    public static void main(String[] args) {

        System.out.println(sumList(List.of("1", "123")));
        System.out.println(sumList(List.of("123", "1")));

    }

    private static String sumList(List<String> list) {
        return list.stream()
                .map(CalculateSumOfNumbersInList::digitSum)
                .reduce(0, Integer::sum)
                .toString();
    }

    static Map<String, Integer> cache = new HashMap<>();

    private static Integer digitSum(String s) {
        if (cache.containsKey(s)) {
            System.out.println("Get from cache " + s);
            return cache.get(s);
        }

        final Integer digitSum = String.valueOf(s).chars()
                .map(c -> c - '0')
                .boxed()
                .reduce(0, Integer::sum);

        cache.put(s, digitSum);
        return digitSum;
    }
}
