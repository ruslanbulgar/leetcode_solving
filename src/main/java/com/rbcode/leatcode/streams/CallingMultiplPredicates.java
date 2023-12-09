package com.rbcode.leatcode.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class CallingMultiplPredicates {

    public static void main(String[] args) {
        final Stream<Predicate<Void>> allPredicates = Stream.of(
                x -> v1(),
                x -> v2(),
                x -> v3());

        System.out.println(allPredicates.reduce(x->true, Predicate::and).test(null));
    }

    private static boolean v1() {
        System.out.println("v1");
        return false;
    }

    private static boolean v2() {
        System.out.println("v2");
        return true;
    }

    private static boolean v3() {
        System.out.println("v3");
        return false;
    }
}
