package com.rbcode.solutions.composite_pattern.rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrRule implements Rule {
    private final Rule rule1;
    private final Rule rule2;

    @Override
    public boolean isSatisfied() {
        return this.rule1.isSatisfied() || this.rule2.isSatisfied();
    }
}
