package com.rbcode.solutions.composite_pattern.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AndRule implements Rule {
    private final Rule rule1;
    private final Rule rule2;

    @Override
    public Rule and(Rule rule) {
        return this.and(rule);
    }

    @Override
    public boolean isSatisfied() {
        return this.rule1.isSatisfied() && this.rule2.isSatisfied();
    }
}
