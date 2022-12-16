package com.example.demo;

public class PCGen {
    static int maxHP = 20;
    static int HP = maxHP;
    private static int STR;
    private static int DEX;
    private static int INT;
    static int GP = 0;

    static String weapon = "Unarmed";
    static String armor = "No armor";
    static boolean hasShield = false;
    static int damage;
    static int damageTaken;

    //Stat set/get methods
    public static void stats() {
        STR = Dice.stats();
        DEX = Dice.stats();
        INT = Dice.stats();
    }
    public static int getSTR() {
        return STR;
    }
    public static int getDEX() {
        return DEX;
    }
    public static int getINT() {
        return INT;
    }


    //Damage and HP
    public static int attack() {
        if(weapon.equals("Dagger")){
            damage = (STR/3) + 1;
        }else if(weapon.equals("Shortsword")){
            damage = (STR/3) + 2;
        }else if(weapon.equals("Longsword")){
            damage = (STR/3) + 3;
        }else if(weapon.equals("Greatsword")){
            damage = (STR/3) + 4;
        }else{
            damage = (STR/3);
        }
        return damage;
    }
    public static int defense() {
        if(armor.equals("Leather Armor")){
            damageTaken = ((NPCGen.getStats()*2)/3) - 1;
        }else if(armor.equals("Breastplate")){
            damageTaken = ((NPCGen.getStats()*2)/3) - 2;
        }else if(armor.equals("Chain Mail")){
            damageTaken = ((NPCGen.getStats()*2)/3) - 3;
        }else if(armor.equals("Plate Mail")){
            damageTaken = ((NPCGen.getStats()*2)/3) - 4;
        }else{
            damageTaken = ((NPCGen.getStats()*2)/3);
        }
        if(hasShield == true){
            damageTaken = damageTaken - 1;
        }
        if(damageTaken < 1){
            damageTaken = 1;
        }
        HP = HP - damageTaken;

        return damageTaken;
    }

    public static void reset() {
        maxHP = 20;
        HP = maxHP;
        stats();
        weapon = "Unarmed";
        armor = "No armor";
        GP = 0;
    }
}
