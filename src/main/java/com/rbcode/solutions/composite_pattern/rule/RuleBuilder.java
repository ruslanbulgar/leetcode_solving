package com.rbcode.solutions.composite_pattern.rule;

public class RuleBuilder {

    public static void main(String[] args) {

        Rule rule1 = new FormatValidationRule("1000000000");

        Rule rule2 = new DateValidationRule("10/10/2024");
        Rule rule3 = new FormatValidationRule("100000000");

        System.out.println(rule1.and(rule2).isSatisfied());
        System.out.println(rule1.or(rule3).isSatisfied());
    }
}
