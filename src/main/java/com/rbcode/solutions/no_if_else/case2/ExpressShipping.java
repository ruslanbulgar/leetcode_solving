package com.rbcode.solutions.no_if_else.case2;

public class ExpressShipping implements ShippingCost {
    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }

    @Override
    public Type type() {
        return Type.EXPRESS;
    }
}
