package sample;

import sample.EnemyCode.BossEnemy;
import sample.EnemyCode.SmallerEnemy;
import sample.GameTile.Tower.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.EnemyCode.NormalEnemy;
import sample.Player.Player;
import sample.Shop.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private MapGame mapGame;
    public Menu menu;
    private Player player;
    public GameField(){
        towers = new ArrayList<>();
        mapGame = new MapGame();
        enemies = new ArrayList<>();
        menu = new Menu();
        player = new Player();
    }
    public void AddEnemy(int number){
        for(int i = 0; i < number; i++){
            enemies.add(new NormalEnemy());
            enemies.add(new BossEnemy());
            enemies.add(new SmallerEnemy());
        }
    }
    public void addTower(Tower tower){
        towers.add(tower);
    }
    public void show(GameStage gameStage, long time){
        mapGame.show(gameStage);



        for (Enemy enemy : enemies){
            enemy.move(gameStage.getGC());
            enemy.show(gameStage.getGC());
        }

        for(Tower tower: towers){
            tower.show(gameStage.getGC(), time);
        }

        menu.show(gameStage.getGC());

        showDetails(gameStage.getGC());
    }


    public void play(GraphicsContext gc, long curTime){

        for(Tower tower: towers){
            if(tower.getFire()){
                tower.attack(gc);
                continue;
            }
            for(int i = 0; i < enemies.size(); i++){
                Enemy enemy = enemies.get(i);
                if(enemy.isDead()){
                    player.bonus(enemy.getPrize());
                    enemies.remove(enemy);
                    i--;
                }else{
                    if(tower.inRange(enemy) && tower.isFree(curTime)){
                        tower.attack(enemy,gc);
                    }
                }
            }
        }
    }
    public Player getPlayer(){
        return player;
    }

    public void buildTower(double x, double y,GameStage gameStage){
        if(menu.openMenu){
            menu.preView(gameStage.getGC());
            Tower tower = menu.buildTower(x,y,this.player);
            if(tower == null){
                return;
            }
            addTower(tower);
        }
    }
    private void showDetails(GraphicsContext gc){
        player.show(gc);
        Image tree = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\treeUp.png");
        gc.drawImage(tree,262,14,147,148);
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

/*
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
 */