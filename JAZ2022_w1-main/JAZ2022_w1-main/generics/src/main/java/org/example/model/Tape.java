package org.example.model;

import org.example.IMakeNoise;

public class Tape extends SavingMedium{

    @Override
    public void save(IMakeNoise noise) {
        System.out.println("Saved on Tape: ");
        noise.makeNoise();
    }
}
