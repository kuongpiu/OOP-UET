package sample;

import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import sample.EnemyCode.Enemy;
import sample.EnemyCode.NormalEnemy;
import sample.GameTile.PosTower;
import sample.GameTile.Tower.Bullet;
import sample.GameTile.Tower.MagicTower;
import sample.GameTile.Tower.NormalTower;
import sample.GameTile.Tower.Tower;

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

               // System.out.println(x + "-" + y);
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
                    gameField.addTower(new MagicTower(  px,py));
                    PosTower.build();
                }
            }
        });

        new AnimationTimer(){

            @Override
            public void handle(long currentNanoTime) {

                gameField.show(stage);
                gameField.play(stage.getGC(), currentNanoTime/TIME);
                //System.out.println(currentNanoTime/TIME);


            }
        }.start();
        stage.show(stage.getScene());
    }
}
/*
                LongValue lastNanoTime = new LongValue( System.nanoTime() );
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
 */
