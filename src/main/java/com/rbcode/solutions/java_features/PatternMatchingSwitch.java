package com.rbcode.solutions.java_features;

import static java.util.Collections.singletonList;

public class PatternMatchingSwitch {
    public static void main(String[] args) {
        System.out.println(format(1L));
        System.out.println(format(0.4));
        System.out.println(format("Hi"));
        System.out.println(format(singletonList("Jo")));

        System.out.println(getFormattedString(null));
        System.out.println(getFormattedString("yes"));
        System.out.println(getFormattedString("no"));
        System.out.println(getFormattedString("1"));
    }

    private static String format(Object object) {
        return switch (object) {
            case Long l -> String.format("Long %d", l);
            case Double d -> String.format("Double %f", d);
            case String s -> String.format("String %s", s);
            default -> object.toString();
        };
    }

    private static String getFormattedString(String value) {
        return switch (value) {
            case null -> "Null value received";
            case "yes", "no" -> String.format("Result is : %s", value);
            default -> "unknown";
        };
    }
}
