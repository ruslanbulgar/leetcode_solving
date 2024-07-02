package com.rbcode.leatcode.java17_features;

import java.util.random.RandomGeneratorFactory;

public class PseudoRandom {

    public static void main(String[] args) {
        RandomGeneratorFactory.all()
                .map(f -> f.name())
                .sorted()
                .forEach(n -> System.out.println(n));

        RandomGeneratorFactory.all().forEach(r-> System.out.println(r.name() + "  " + r.create().nextInt()));


    }
}
