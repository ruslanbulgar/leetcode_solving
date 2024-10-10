package com.rbcode.solutions.no_if_else.case2;

public class StandardShipping implements ShippingCost {
    @Override
    public double calculate(double weight) {
        return weight * 5.0;
    }

    @Override
    public Type type() {
        return Type.STANDARD;
    }
}
