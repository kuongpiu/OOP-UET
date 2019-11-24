package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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

                loadMenu(gameField.menu,x,y);


            }
        });

        new AnimationTimer(){

            @Override
            public void handle(long currentNanoTime) {
                long time = currentNanoTime/TIME;
                gameField.show(stage, time);
                gameField.play(stage.getGC(), time);
                gameField.createEnemy(time);
                gameField.buildTower(GameStage.curMouse.getX(),GameStage.curMouse.getY(),stage);
                //drawCircle(gc);
                System.out.println(time);
            }
        }.start();
        stage.show();
    }
    private void drawCircle(GraphicsContext gc){
        double x = 0;
        double y = 0;
        Image image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\cungten.png");
        gc.save();

        gc.translate(GameStage.curMouse.getX(),GameStage.curMouse.getY());
        gc.rotate(0);
        gc.drawImage(image,0,0);

        gc.restore();

    }
    private void loadMenu(Menu menu, int x, int y){

        if(menu.openMenu == true){
            menu.buyItem = menu.isBuy(x,y);
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
