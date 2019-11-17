package sample.EnemyCode;

import javafx.scene.image.Image;
import sample.GameField;
import sample.GameTile.Road;
import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

import java.util.Random;

public abstract class Enemy implements GameEntity {
    protected double x,y,vx,vy;
    protected int w,h;
    protected int blood, prize, velocity;
    protected int pos = 0;
    protected Image image;

    public Enemy(TypeEnemy type){
        x = new Random().nextInt(700) - 700;
        y = new Random().nextInt(400) + 400;

        switch (type){
            case SMALLER_ENEMY:
                blood = Blood.NORMAL_BLOOD;
                prize = Prize.NORMAL_PRIZE;
                w = 20;
                h = 30;
                velocity = 2;
                break;
            case BOSS_ENEMY:
                blood = Blood.HIGH_BLOOD;
                prize = Prize.HIGH_PRIZE;
                velocity = 1;
                break;
            case NORMAL_ENEMY:
                blood = Blood.LOW_BLOOD;
                prize = Prize.NORMAL_PRIZE;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\monster.png");
                velocity = 1;
                w = 40;
                h = 50;
                break;
            case TANKER_ENEMY:
                blood = Blood.HIGH_BLOOD * 2;
                prize = Prize.HIGH_PRIZE * 2;
                velocity = 1;
        }


    }
    abstract public void move(GraphicsContext gc, Road road);
    public double getX(){
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    public double getY() {
        return y;
    }


    public void show(GraphicsContext gc){
        Image monster = GameField.loadImage("D:\\Github\\OOP-UET\\monster.png");
        gc.drawImage(monster,x,y,w,h);
    }

    protected void posTarget(Road road){
        if(pos < road.posX.size()){
            vx =  road.getX(pos) - x;//(new Random().nextInt(10) - 10)
            vy =  road.getY(pos)- h - y;
        }else{
            pos = 0;
            x = new Random().nextInt(1000) - 1000;
            y = new Random().nextInt(500) + 500;
        }
        double sum = vx*vx + vy*vy;
        sum = Math.sqrt(sum);
        vx /= sum;
        vy /= sum;
        vx *= velocity;
        vy *= velocity;
    }


    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
