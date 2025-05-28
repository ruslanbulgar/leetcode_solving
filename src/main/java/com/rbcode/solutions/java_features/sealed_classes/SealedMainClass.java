package com.rbcode.solutions.java_features.sealed_classes;

import java.util.ArrayList;
import java.util.List;

public class SealedMainClass {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Mercedes());
        cars.add(new BMW());
        cars.add(new VW());
        cars.add(new Mercedes());
        cars.add(new Mercedes());
        cars.add(new VW());
        cars.add(new Kia());
        cars.add(new Kia());
        cars.add(new Kia());

        //Will use pattern matching instanceof to check if the car is a germanCar and to call its method
        cars.forEach(car -> {
            car.carName();
            if (car instanceof GermanCar germanCar) {
                germanCar.germanLicence();
            }
        });
    }
}
