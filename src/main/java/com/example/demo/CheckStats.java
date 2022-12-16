package com.example.demo;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CheckStats {

    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("PC Stats");
        window.setMinWidth(400);

        Label pcStats = new Label("Your Stats:");
        Label hitPoints = new Label("HP: " + PCGen.HP + " / " + PCGen.maxHP);
        Label strength = new Label("STR: " + PCGen.getSTR());
        Label dexterity = new Label("DEX: " + PCGen.getDEX());
        Label intelligence = new Label("INT: " + PCGen.getINT());
        Label goldPieces = new Label("GP: " + PCGen.GP);

        GridPane stats = new GridPane();
        GridPane.setConstraints(pcStats,0,0);
        GridPane.setConstraints(hitPoints,1,0);
        GridPane.setConstraints(strength,0,1);
        GridPane.setConstraints(dexterity,1,1);
        GridPane.setConstraints(intelligence,0,2);
        GridPane.setConstraints(goldPieces,1,2);

        stats.getChildren().addAll(pcStats,hitPoints,strength,dexterity,intelligence,goldPieces);
        stats.setAlignment(Pos.CENTER);
        stats.setStyle("-fx-alignment: center");
        Scene scene = new Scene(stats);
        window.setScene(scene);
        window.showAndWait();
    }
}
