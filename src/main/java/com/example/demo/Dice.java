package com.example.demo;

import java.util.Random;

public class Dice {

    public static int rng(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static int stats() {
        int sTotal = 0;
        Random r = new Random();

        for(int i = 0; i < 3; i++){
            sTotal = sTotal + ((r.nextInt(6 - 1) + 1) + 1);
        }
        return sTotal;
    }
}
