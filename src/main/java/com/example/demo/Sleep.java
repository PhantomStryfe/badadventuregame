package com.example.demo;

public class Sleep {

    public static void resting() {
        PCGen.HP = PCGen.maxHP;
        System.out.println("HP Restored!");
        Generator.npcGenerator();
        if(Generator.NPC == true) {
            Combat.npcAttack();
        }
    }
}
