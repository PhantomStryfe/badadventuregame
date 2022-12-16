package com.example.demo;

public class NPCGen {
    static int HP;
    static int stats;
    static int loot;

    //Get/Set stats
    public static void npcStats() {
        int mod = Dice.rng(1,6);
        HP = mod;
        stats = mod*2;
    }
    public static int getNPCHealth() {
        return HP;
    }
    public static int getStats() {
        return stats;
    }

    //Loot drops
    public static void lootDrops(){
        loot = Dice.rng(1,6) + Dice.rng(1,6);
    }
    public static int getLootDrops() {
        PCGen.GP = PCGen.GP + loot;
        return loot;
    }

    public static void NPCReset() {
        npcStats();
        lootDrops();
        Generator.NPC = false;
    }
}
