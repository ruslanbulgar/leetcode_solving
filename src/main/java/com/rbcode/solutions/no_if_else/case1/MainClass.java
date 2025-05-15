package com.rbcode.solutions.no_if_else.case1;

public class MainClass {
    public static void main(String[] args) {
        calculateShippingCost(ShippingType.STANDARD, 2.3);
        calculateShippingCost(ShippingType.SAME_DAY, 2.3);
        calculateShippingCost(ShippingType.OVERNIGHT, 2.3);
        calculateShippingCost(ShippingType.INTERNATIONAL, 2.3);
        calculateShippingCost(ShippingType.EXPRESS, 2.3);
    }

    private static double calculateShippingCost(ShippingType shippingType, double weight) {
        double cost = shippingType.getCost(weight);
        System.out.println(String.format("Cost to ship [%s] kg with [%s] type is [$%s]", weight, shippingType.name(), cost));
        return cost;
    }
}
