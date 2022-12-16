package com.example.demo;

public class Generator {

    public static boolean NPC = false;
    public static int exits = 0;

    public static void exitGenerator() {
        exits = Dice.rng(1,4);
        if(exits == 1){
            System.out.println("Only one way out. Better head downwards.");
        }else if(exits == 2){
            System.out.println("Turn around or go right.");
        }else if(exits == 3){
            System.out.println("There's a fork in the road. Turn right or left, or go back.");
        }else{
            System.out.println("Pick a direction.");
        }
    }

    public static void npcGenerator() {
        int luck = Dice.rng(1,6);
        if(luck == 1){
            NPC = true;
            System.out.println("An aggressive NPC appeared!");
        }
    }

    public static void lootGen() {
        int result = Dice.rng(1,20);
        if(result <= PCGen.getINT()){
            int r = Dice.rng(1,6) + Dice.rng(1,6) + Dice.rng(1,6);
            System.out.println("You found " + r + " GP!");
            PCGen.GP = PCGen.GP + r;
        }
    }
}
