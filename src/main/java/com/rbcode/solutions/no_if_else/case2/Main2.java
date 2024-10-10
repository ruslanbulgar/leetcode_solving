package com.rbcode.solutions.no_if_else.case2;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main2 {

    static List<ShippingCost> shippingCosts = loadImplementations();

    public static void main(String[] args) {

        calculateShippingCost(Type.STANDARD, 2.3);
        calculateShippingCost(Type.SAME_DAY, 2.3);
        calculateShippingCost(Type.OVERNIGHT, 2.3);
        calculateShippingCost(Type.INTERNATIONAL, 2.3);
        calculateShippingCost(Type.EXPRESS, 2.3);
    }

    private static double calculateShippingCost(Type shippingType, double weight) {
        double cost = shippingCosts.stream().filter(sc->sc.isType(shippingType)).findFirst().get().calculate(weight);
        System.out.println(String.format("Cost to ship [%s] kg with [%s] type is [$%s]", weight, shippingType.name(), cost));
        return cost;
    }

    public static List<ShippingCost> loadImplementations() {
        List<ShippingCost> implementations = new ArrayList<>();

        // Scan the package where the implementations are located
        Reflections reflections = new Reflections("com.rbcode");
        Set<Class<? extends ShippingCost>> classes = reflections.getSubTypesOf(ShippingCost.class);

        // Instantiate each implementation and add it to the list
        for (Class<? extends ShippingCost> clazz : classes) {
            try {
                ShippingCost instance = clazz.getDeclaredConstructor().newInstance();
                implementations.add(instance);
            } catch (Exception e) {
                System.err.println("Failed to instantiate " + clazz.getName() + ": " + e.getMessage());
            }
        }

        return implementations;
    }
}
