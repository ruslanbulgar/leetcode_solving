package com.rbcode.solutions.no_if_else.case2;

public class InternationalShipping implements ShippingCost {
    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }

    @Override
    public Type type() {
        return Type.INTERNATIONAL;
    }
}
