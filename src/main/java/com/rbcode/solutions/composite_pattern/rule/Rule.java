package com.rbcode.solutions.composite_pattern.rule;

public interface Rule {
    default Rule and(Rule rule) {
        return new AndRule(this, rule);
    }

    default Rule or(Rule rule) {
        return new OrRule(this, rule);
    }

    boolean isSatisfied();
}
