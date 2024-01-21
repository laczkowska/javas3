package org.example.model;

import org.example.IMakeNoise;

public class Animal implements IMakeNoise {
    public void makeNoise() {
        System.out.println("Animal Voice");
    }
}
