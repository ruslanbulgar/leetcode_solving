package com.rbcode.solutions.java_features.sealed_classes;

public final class VW implements GermanCar {
    @Override
    public void carName() {
        System.out.println("VW");
    }

    @Override
    public void germanLicence() {
        System.out.println("G1001");
    }
}
