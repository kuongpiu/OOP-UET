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
import java.util.Random;


public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private int wave = 0,step = 0;
    private MapGame mapGame;
    public Menu menu;
    private Player player;
    private Random random = new Random();
    public GameField(){
        towers = new ArrayList<>();
        mapGame = new MapGame();
        enemies = new ArrayList<>();
        menu = new Menu();
        player = new Player();
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
    public void createEnemy(long time){
        if(enemies.isEmpty()){
            step++;
            addEnemy(step);
        }
        if(step == 5){
            wave = 1;
        }else if(step == 10){
            wave = 2;
        }else if(step > 15){
            wave = 3;
        }
    }
    private void addEnemy(int num){
        for(int i = 0; i < num; i++){
            if(wave == 0){
                enemies.add(new SmallerEnemy());
                initXY(enemies.get(enemies.size()-1));
            }else if(wave == 1){
                enemies.add(new SmallerEnemy());
                initXY(enemies.get(enemies.size()-1));
                enemies.add(new NormalEnemy());
                initXY(enemies.get(enemies.size()-1));
            }else if(wave == 2){
                enemies.add(new SmallerEnemy());
                initXY(enemies.get(enemies.size()-1));
                enemies.add(new NormalEnemy());
                initXY(enemies.get(enemies.size()-1));
                enemies.add(new BossEnemy());
                initXY(enemies.get(enemies.size()-1));
            }
        }
    }
    private void initXY(Enemy enemy){
        double x,y;
        if(wave == 1){
            x = random.nextInt(400)  - 550;
            y = random.nextInt(300) + GameStage.MAX_HEIGHT + 50;
        }else if(wave == 2){
            x = random.nextInt(800)  - 900;
            y = random.nextInt(500) + GameStage.MAX_HEIGHT + 200;
        }else {
            x = random.nextInt(200)  - 250;
            y = random.nextInt(200) + GameStage.MAX_HEIGHT + 20;
        }
        enemy.setX(x);
        enemy.setY(y);
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