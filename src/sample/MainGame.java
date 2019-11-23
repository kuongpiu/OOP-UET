package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.GameTile.PosTower;
import sample.Shop.Menu;

public class MainGame {
    private static final long TIME = 100000000;
    public void play(GameStage stage){
        GraphicsContext gc = stage.getGC();
        stage.setGameGroup();
        GameField gameField = new GameField();
        gameField.AddEnemy(10);
        stage.getScene().setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x = (int)mouseEvent.getX();
                int y = (int)mouseEvent.getY();

                GameStage.curMouse.setX(x);
                GameStage.curMouse.setY(y);
                System.out.println(x + "-" + y);

            }
        });


        stage.getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x = (int)mouseEvent.getX();
                int y = (int)mouseEvent.getY();
                if(PosTower.isContains(x,y)){
                    loadMenu(gameField.menu, x,y);
                }
                loadMenu(gameField.menu, x,y);

            }
        });

        new AnimationTimer(){

            @Override
            public void handle(long currentNanoTime) {
                long time = currentNanoTime/TIME;
                gameField.show(stage, time);
                gameField.play(stage.getGC(), time);

                gameField.buildTower(GameStage.curMouse.getX(),GameStage.curMouse.getY(),stage);
                //drawCircle(gc);
            }
        }.start();
        stage.show();
    }
    private void drawCircle(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.setLineWidth(1);
        gc.setGlobalAlpha(1);
        gc.fillOval(GameStage.curMouse.getX() - 25, GameStage.curMouse.getY() - 25, 50,50);
        gc.strokeOval(GameStage.curMouse.getX() - 25 , GameStage.curMouse.getY() - 25, 50,50);
        gc.setGlobalAlpha(1);
    }
    private void loadMenu(Menu menu, int x, int y){

        if(menu.openMenu == true){
            menu.buyItem = menu.isContains(x,y);
        }
        else{
            menu.openMenu = true;
            menu.setXY(x,y);
        }
    }
}
/*
                LongValue lastNanoTime = new LongValue( System.nanoTime() );
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
 */
