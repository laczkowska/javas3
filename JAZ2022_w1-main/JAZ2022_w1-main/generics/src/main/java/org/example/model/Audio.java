package org.example.model;

import org.example.IMakeNoise;

public class Audio implements IMakeNoise {
    @Override
    public void makeNoise() {
        System.out.println("Telling A Story...");
    }
}
