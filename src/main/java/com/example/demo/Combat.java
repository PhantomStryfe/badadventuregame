package com.example.demo;

public class Combat {

    static int damageDealt;

    public static void fight() {
        if(Generator.NPC == true){
            int acc = Dice.rng(1,20);
            if(acc >= NPCGen.getStats()){
                System.out.println("Hit!");
                damageDealt = PCGen.attack();
                System.out.println("Your attack dealt " + damageDealt + " points of damage.");
                NPCGen.HP = NPCGen.HP - damageDealt;
            }else{
                System.out.println("You missed...");
            }
            if(NPCGen.HP <= 0) {
                System.out.println("You killed the NPC!");
                int loot = NPCGen.getLootDrops();
                System.out.println("You found " + loot + " GP!");
                NPCGen.NPCReset();
            }else{
                System.out.println("The NPC seizes the opportunity to make an attack!");
                npcAttack();
            }
        }else{
            System.out.println("But there was no target...");
        }
    }

    public static void flee(){
        int DC = NPCGen.getStats();
        int perception = Dice.rng(1,20);

        if(perception < DC){
            System.out.println("The NPC seizes the opportunity to make an attack!");
            npcAttack();
        }else{
            System.out.println("It appears the NPC doesn't notice you...");
        }
        System.out.println("Now's the time to make your escape! Or maybe steal some loot before you go...");
    }

    public static void npcAttack(){
        int acc = Dice.rng(1,20);
        if(acc >= PCGen.getDEX()){
            System.out.println("Oh no! You've been hit!");
            damageDealt = PCGen.defense();
            System.out.println("You took " + damageDealt + " points of damage. Recalculating HP...");
            if(PCGen.HP < 0){
                PCGen.HP = 0;
            }
            System.out.println("\nCurrent HP: " + PCGen.HP);
            if(PCGen.HP == 0){
                System.out.println("Oh no! You died. Game over.");
                Main.sceneSwitch(4);
            }
        }else{
            System.out.println("The NPC missed its attack!");
        }
    }
}
