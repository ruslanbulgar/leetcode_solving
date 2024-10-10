package com.rbcode.solutions.no_if_else.case2;

public class OvernightShipping implements ShippingCost {
    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }

    @Override
    public Type type() {
        return Type.OVERNIGHT;
    }
}
