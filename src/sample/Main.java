package sample;

import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameStage gameStage = new GameStage(primaryStage);
        GameStart gameStart = new GameStart();
        gameStart.start(gameStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
