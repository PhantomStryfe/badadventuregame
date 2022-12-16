package com.example.demo;

public class DPad {

    public static void right(){
        if(Generator.exits == 1){
            System.out.println("You can't go that way.");
        }else{
            System.out.println("You head right, into a new room.");
            Generator.exitGenerator();
            Generator.npcGenerator();
        }
    }

    public static void left(){
        if(Generator.exits == 1 || Generator.exits == 2){
            System.out.println("You can't go that way");
        }else{
            System.out.println("You head left, into a new room.");
            Generator.exitGenerator();
            Generator.npcGenerator();
        }
    }

    public static void up(){
        if(Generator.exits == 4){
            System.out.println("You head forwards, into a new room.");
            Generator.exitGenerator();
            Generator.npcGenerator();
        }else{
            System.out.println("You can't go that way");
        }
    }

    public static void down(){
        System.out.println("You turn around and head backwards, into a new room. Even if you thought you had been here, it appears that it has changed...");
        Generator.exitGenerator();
        Generator.npcGenerator();
    }
}
