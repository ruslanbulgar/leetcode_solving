package com.rbcode.solutions.no_if_else.case2;

public interface ShippingCost {
    double calculate(double weight);

    Type type();

    default boolean isType(Type type) {
        return type() == type;
    }
}
