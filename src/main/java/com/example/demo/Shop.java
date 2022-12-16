package com.example.demo;

public class Shop {

    public static String itemName = "";
    public static int price = 0;
    public static int populate() {
        int itemNum = Dice.rng(1,12);
        return itemNum;
    }

    public static void itemConvert(int itemNum){
        if(itemNum == 1){
            itemName = "Dagger";
            price = 2;
        }else if(itemNum == 2){
            itemName = "Shortsword";
            price = 15;
        }else if(itemNum == 3){
            itemName = "Longsword";
            price = 35;
        }else if(itemNum == 4){
            itemName = "Greatsword";
            price = 50;
        }else if(itemNum == 5){
            itemName = "Leather Armor";
            price = 25;
        }else if(itemNum == 6){
            itemName = "Breastplate";
            price = 60;
        }else if(itemNum == 7){
            itemName = "Chain Mail";
            price = 100;
        }else if(itemNum == 8){
            itemName = "Plate Mail";
            price = 150;
        }else if(itemNum == 9){
            itemName = "Shield";
            price = 15;
        }else if(itemNum == 10){
            itemName = "Health Potion";
            price = 75;
        }else if(itemNum == 11){
            itemName = "The Tale of Scanlan Shorthalt";
            price = 500;
        }else if(itemNum == 12){
            itemName = "Treasure...?";
            price = 1;
        }
    }

    public static String getItemName(){
        return itemName;
    }
    public static int getPrice(){
        return price;
    }
}
