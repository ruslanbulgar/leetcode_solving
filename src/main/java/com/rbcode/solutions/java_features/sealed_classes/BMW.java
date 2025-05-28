package com.rbcode.solutions.java_features.sealed_classes;

public final class BMW implements GermanCar {

    @Override
    public void carName() {
        System.out.println("BMW");
    }

    @Override
    public void germanLicence() {
        System.out.println("G1002");
    }
}
