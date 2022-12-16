package com.example.demo;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class Main extends Application {

    static Stage window;
    //Universal menu
    Button play,pause,home,resume,exit;
    //Main game menu
    Button search,sleep,fight,run,stats,stats2,shop,exitShop;
    //Navigation menu
    Button right,left,up,down;
    static Scene homeScene;
    static Scene gameScene;
    static Scene pauseScene;
    static Scene shopScene;

    int itemNum1, itemNum2, itemNum3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bad Adventure Game");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //Home Screen
        Label intro = new Label("Do you want to play a Bad Adventure Game?");
        play = new Button("Click to play!");
        play.setOnAction(e -> {
            System.out.println("Initializing game...");
            PCGen.reset();
            Generator.exitGenerator();
            sceneSwitch(1);
        });

        VBox homeScreen = new VBox(20);
        homeScreen.setStyle("-fx-alignment: center");
        homeScreen.getChildren().addAll(intro,play);
        homeScene = new Scene(homeScreen,1000,300);
        sceneSwitch(4);
        window.show();


    //Main Game
        //Menus
        GridPane game = new GridPane();
        game.setStyle("-fx-background-color: white; -fx-alignment: center; -fx-grid-lines-visible: true");
        for(int i=0;i<15;i++){
            ColumnConstraints column = new ColumnConstraints(80);
            game.getColumnConstraints().add(column);
        }
        game.setPadding(new Insets(10,10,10,10));
        game.setVgap(8);
        game.setHgap(10);

        pause = new Button("Pause");
        exit = new Button("Exit");
        exit.setOnAction(e -> closeProgram());
        shop = new Button("Shop");
        shop.setOnAction(e -> {
            System.out.println("Entering shop...");
            itemNum1 = Shop.populate();
            itemNum2 = Shop.populate();
            itemNum3 = Shop.populate();
            sceneSwitch(3);
        });

        search = new Button("Search Room");
        search.setOnAction(e -> Generator.lootGen());

        sleep = new Button("Sleep");
        sleep.setOnAction(e -> Sleep.resting());

        fight = new Button("Fight!");
        fight.setOnAction(e -> Combat.fight());

        run = new Button("Run Away!");
        run.setOnAction(e -> Combat.flee());

        stats = new Button("Stats");
        stats.setOnAction(e -> {
            System.out.println("Opening stat menu");
            CheckStats.display();
        });
        stats2 = new Button("Stats");
        stats2.setOnAction(e -> {
            System.out.println("Opening stat menu");
            CheckStats.display();
        });

        right = new Button("Right");
        right.setOnAction(e -> DPad.right());
        left = new Button("Left");
        left.setOnAction(e -> DPad.left());
        up = new Button("Up");
        up.setOnAction(e -> DPad.up());
        down = new Button("Down");
        down.setOnAction(e -> DPad.down());

        pause.setOnAction(e -> {
            System.out.println("Pausing game...");
            sceneSwitch(2);
        });

        GridPane.setConstraints(pause,11,0);
        GridPane.setConstraints(exit,11,2);
        GridPane.setConstraints(shop,11,6);
        GridPane.setConstraints(stats2,11,8);

        GridPane.setConstraints(fight,0,0);
        GridPane.setConstraints(search,0,2);
        GridPane.setConstraints(sleep,0,4);
        GridPane.setConstraints(run,0,6);
        GridPane.setConstraints(stats,0,8);

        GridPane.setConstraints(up,13,2);
        GridPane.setConstraints(right,14,4);
        GridPane.setConstraints(left,12,4);
        GridPane.setConstraints(down,13,6);

        game.getChildren().addAll(pause,exit,shop,stats2,fight,search,sleep,run,stats,up,right,left,down);
        gameScene = new Scene(game,1500 ,300);
        sceneSwitch(1);
        window.show();

        //Shop Menu
        GridPane shopPane = new GridPane();

        Button item1 = new Button(Shop.getItemName());
        Button item2 = new Button(Shop.getItemName());
        Button item3 = new Button(Shop.getItemName());

        exitShop = new Button("Exit the Shop?");
        exitShop.setOnAction(e -> {
            System.out.println("Exiting shop...");
            sceneSwitch(1);
        });

        GridPane.setConstraints(exitShop,2,0);
        GridPane.setConstraints(item1,1,3);
        GridPane.setConstraints(item2,2,3);
        GridPane.setConstraints(item3,3,3);

        shopPane.getChildren().addAll(exitShop,item1,item2,item3);
        shopScene = new Scene(shopPane,1000,300);
        sceneSwitch(1);
        window.show();


        //Pause Menu
        home = new Button("Return to Home Screen?");
        home.setOnAction(e -> {
            System.out.println("Returning to the home screen...");
            sceneSwitch(4);
        });

        resume = new Button("Return to Game?");
        resume.setOnAction(e -> {
            System.out.println("Resuming game...");
            sceneSwitch(1);
        });

        VBox pauseMenu = new VBox(20);
        pauseMenu.getChildren().addAll(home,resume);
        pauseScene = new Scene(pauseMenu,500,500);
        sceneSwitch(2);
        window.show();

        sceneSwitch(4);
        window.show();
    }

    public static void sceneSwitch(int i){
        switch(i){
            case 1:
                window.setScene(gameScene);
                break;
            case 2:
                window.setScene(pauseScene);
                break;
            case 3:
                window.setScene(shopScene);
                break;
            case 4:
                window.setScene(homeScene);
                break;
        }

    }

    private void closeProgram() {
        Boolean result = ConfirmBox.display("Exit","Are you sure you want to exit?");
        if(result == true) {
            window.close();
        }
    }
}
