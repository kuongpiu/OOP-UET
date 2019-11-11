package sample;

import javafx.stage.Stage;
import sample.GameTile.GameTile;
import sample.GameTile.Tower.NormalTower;
import sample.GameTile.Tower.Tower;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import sample.EnemyCode.Enemy;
import sample.EnemyCode.NormalEnemy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private MapGame mapGame;
    public GameField(){
        towers = new ArrayList<>();
        mapGame = new MapGame();
        enemies = new ArrayList<>();
    }
    public void AddEnemy(int number){
        for(int i = 0; i < number; i++){
            enemies.add(new NormalEnemy());
        }
    }
    public void addTower(Tower tower){
        towers.add(tower);
    }
    public void show(GameStage gameStage){
        mapGame.show(gameStage);



        for (Enemy enemy : enemies){
            enemy.move(gameStage.getGC(),mapGame.getRoad());
            enemy.show(gameStage.getGC());
        }

        for(Tower tower: towers){
            tower.show(gameStage.getGC());
        }
    }
    public static boolean inRange(Tower tower, Enemy enemy){
        double px = enemy.getX() - tower.getX();
        double py = enemy.getY() - tower.getY();
        double distance = px*px + py*py;
        distance = Math.sqrt(distance);
        if(distance <= tower.getRange()){
            return true;
        }else{
            return false;
        }
    }
    public void play(){
        for(Tower tower: towers){
            for(Enemy enemy: enemies){
                if(inRange(tower,enemy) && !tower.getFire()){
                    tower.setTarget(enemy);
                }else{
                    tower.reset();
                }

            }
        }
    }






















    public static Image loadImage(String str){
        Image res = null;
        try {
            FileInputStream file = new FileInputStream(str);
            res = new Image(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        return res;
    }


}