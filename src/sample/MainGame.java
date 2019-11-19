package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.GameTile.PosTower;
import sample.Shope.Menu;

public class MainGame {
    private static final long TIME = 100000000;
    public void play(GameStage stage){

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
                    int px = PosTower.posX.get(PosTower.indexOfTower);
                    int py = PosTower.posY.get(PosTower.indexOfTower);
                    //gameField.addTower(new MagicTower(px,py));
                    loadMenu(gameField.menu, x,y);
                }else {
                    gameField.buildTower(x,y);
                }
            }
        });
        GraphicsContext gc = stage.getGC();
        new AnimationTimer(){

            @Override
            public void handle(long currentNanoTime) {
                long time = currentNanoTime/TIME;
                gameField.show(stage, time);
                gameField.play(stage.getGC(), time);
                //System.out.println(currentNanoTime/TIME);
                drawLine(gc);


            }
        }.start();
        stage.show(stage.getScene());
    }
    private void drawLine(GraphicsContext gc){
        gc.beginPath();
        gc.moveTo(GameStage.curMouse.getX(),GameStage.curMouse.getY());
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.lineTo(GameStage.curMouse.getX() + 50, GameStage.curMouse.getY());
        gc.closePath();
        gc.stroke();



    }
    private void loadMenu(Menu menu, int x, int y){
        if(menu.openMenu == true){
            menu.openMenu = false;
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
