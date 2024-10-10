package com.rbcode.solutions.no_if_else.case2;

public class SameDayShipping implements ShippingCost {
    @Override
    public double calculate(double weight) {
        return weight * 20.0;
    }

    @Override
    public Type type() {
        return Type.SAME_DAY;
    }
}
