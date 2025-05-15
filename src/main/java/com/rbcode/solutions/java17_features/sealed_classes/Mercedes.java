package com.rbcode.solutions.java17_features.sealed_classes;

public final class Mercedes implements GermanCar {
    @Override
    public void carName() {
        System.out.println("Mercedes");
    }

    @Override
    public void germanLicence() {
        System.out.println("G1000");
    }
}
