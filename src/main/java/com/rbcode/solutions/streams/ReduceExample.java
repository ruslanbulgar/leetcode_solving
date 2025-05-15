package com.rbcode.solutions.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReduceExample {


    public static void main(String[] args) {

        computeFactorial();
    }

    private static void computeFactorial() {
        System.out.println("##### Compute Factorial Using Reduce #####");

        int n = 5; // Change this value to compute factorial of a different number

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }

        IntStream.rangeClosed(1, n).reduce((a, b) -> a * b)
                .ifPresent(f -> System.out.println("Factorial of " + n + " is " + f));

    }

    private static void flattenNestedLists() {
        System.out.println("##### Flatten Nested Lists #####");

        var listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));
        List<int[]> listOfLists2 = Arrays.asList(new int[]{1, 2}, new int[]{3, 4}, new int[]{5});

        var all = listOfLists.stream().reduce(
                new ArrayList<>(),
                (allElements, list) -> {
                    allElements.addAll(list);
                    return allElements;
                });
        System.out.println(all);
    }

    private static void groupSumByCondition() {
        System.out.println("##### Group Sum by Condition #####");

        var nums = Arrays.asList(1, 2, 3, 4, 5);

        nums.stream()
                .reduce(new HashMap<>(Map.of("odd", 0, "even", 0)),
                        (map, number) -> {
                            String key = (number % 2 == 0) ? "even" : "odd";
                            map.put(key, map.get(key) + number);
                            return map;
                        },
                        (map1, map2) -> {
                            map1.put("odd", map1.get("odd") + map2.get("odd"));
                            map1.put("even", map1.get("even") + map2.get("even"));
                            return map1;
                        }).forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private static void groupSumByConditionTransaction() {
        System.out.println("##### Group Sum by Condition #####");

        var transactions = Arrays.asList(
                new Transaction("Deposit", 100),
                new Transaction("Withdrawal", 50),
                new Transaction("Deposit", 200),
                new Transaction("Withdrawal", 150),
                new Transaction("Deposit", 300)
        );

        transactions.stream().collect(
                        Collectors.groupingBy(Transaction::type,
                                Collectors.summingInt(Transaction::amount)))
                .forEach((key, value) -> System.out.println(key + " Total: " + value));

    }


    private static void customObjectReduction() {
        System.out.println("##### Custom Object Reduction #####");

        var persons = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 35),
                new Person("Jin", 29));

        persons.stream().reduce((p1, p2) -> p1.age() > p2.age() ? p1 : p2)
                .ifPresent(person -> System.out.println("Oldest person is : [" + person.name() + "] is : " + person.age()));

    }

    private static void mostFrequentCharacter() {
        System.out.println("##### Most Frequent Character #####");

        String input = "banannna";
        var frequencyMap = new HashMap<Character, Integer>();
        for (char c : input.toCharArray()) {
            if (c != ' ') { // Ignore spaces
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        frequencyMap.entrySet().stream()
                .reduce((e1, e2) -> e1.getValue() >= e2.getValue() ? e1 : e2)
                .ifPresent(v -> System.out.println("Most frequent char is : " + v.getKey() + " with: " + v.getValue() + " repetitions"));

    }

    private static void sumOfSquares() {
        System.out.println("##### Sum of Squares #####");

        var nums = Arrays.asList(1, 2, 3, 4);

        int squareSum = nums.stream().reduce(0, (sum, num) -> sum + (num * num));

        System.out.println("Sum of Squares is: " + squareSum);
    }

    private static void booleanAndOr() {
        System.out.println("##### Boolean And/Or #####");

        var bools = Arrays.asList(true, true, false, true);

        bools.stream().reduce((b1, b2) -> b1 && b2).ifPresent(
                r -> System.out.println("Result of AND operation: " + r)
        );

        bools.stream().reduce((b1, b2) -> b1 || b2).ifPresent(
                r -> System.out.println("Result of OR operation: " + r)
        );
    }

    private static void maxAndMinValues() {
        System.out.println("##### Max and Min Values #####");

        var nums = Arrays.asList(7, 2, 9, 4, 6);

        nums.stream().reduce((a, b) -> a >= b ? a : b).ifPresentOrElse(
                max -> System.out.println("Max element is: " + max),
                () -> System.out.println("List is empty")
        );

        nums.stream().reduce((a, b) -> a <= b ? a : b).ifPresentOrElse(
                min -> System.out.println("Min element is: " + min),
                () -> System.out.println("List is empty")
        );
    }

    private static void joinStringWithASeparator() {
        System.out.println("##### Join Strings with a Separator #####");

        var words = Arrays.asList("apple", "banana", "pear");

        words.stream().reduce((w1, w2) -> w1 + ", " + w2).ifPresentOrElse(
                s -> System.out.println("Concatenated string is : " + s),
                () -> System.out.println("List si empty")
        );
    }

    private static void countWords() {
        System.out.println("##### Count number of characters #####");

        var words = Arrays.asList("hello", "world", "java", "stream");

        int count = words.stream().reduce(0, (sum, word) -> sum + word.length(), Integer::sum);

        System.out.println("Result is : " + count);
    }

    private static void longestString() {
        System.out.println("##### Longest String #####");

        var elements = Arrays.asList("strawberry", "apple", "banana", "pear");

        Optional<String> result = elements.stream().reduce((str1, str2) -> str1.length() >= str2.length() ? str1 : str2);

        result.ifPresentOrElse(str -> System.out.println("Longest string is: " + str),
                () -> System.out.println("List is empty"));
    }

    private static void productOfElements() {
        System.out.println("##### Product of elements #####");

        int[] elements = new int[]{1, 2, 3, 4};

        int result = Arrays.stream(elements).reduce(1, (a, b) -> a * b);

        System.out.println("Should be 24: " + result);
    }

    private static void sumOfElements() {
        System.out.println("##### Sum of elements #####");

        int[] elements = new int[]{1, 2, 3, 4, 5};

        int result = Arrays.stream(elements).reduce(0, (a, b) -> a + b);

        int resultWithMethodRef = Arrays.stream(elements).reduce(0, Integer::sum);

        System.out.println("Should be 15: " + result);
        System.out.println("With Method ref Should be 15: " + resultWithMethodRef);
    }

    record Person(String name, int age) {
    }

    record Transaction(String type, int amount) {
    }
}
