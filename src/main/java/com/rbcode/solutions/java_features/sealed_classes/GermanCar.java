package com.rbcode.solutions.java_features.sealed_classes;

public sealed interface GermanCar extends Car permits Mercedes, BMW, VW {

    void germanLicence();
}
