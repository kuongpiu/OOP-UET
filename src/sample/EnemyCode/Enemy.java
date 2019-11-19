package sample.EnemyCode;

import javafx.scene.image.Image;
import sample.GameField;
import sample.GameTile.Road;
import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

import java.util.Random;

public abstract class Enemy implements GameEntity {
    final private Road roadFirst = new Road(1);
    final private Road roadSecond = new Road(2);

    protected double x,y,vx,vy;
    protected int w,h;
    protected int blood, prize, velocity;
    protected int pos = 0;
    protected Image image;

    protected Road road;

    public Enemy(TypeEnemy type){

        x = new Random().nextInt(700) - 700;
        y = new Random().nextInt(1000) + 500;

        switch (type){
            case SMALLER_ENEMY:
                blood = Blood.LOW_BLOOD;
                prize = Prize.NORMAL_PRIZE;
                w = 20;
                h = 25;
                velocity = 2;
                break;
            case BOSS_ENEMY:
                blood = Blood.HIGH_BLOOD;
                prize = Prize.HIGH_PRIZE;
                w = 40;
                h = 50;
                velocity = 1;
                break;
            case NORMAL_ENEMY:
                blood = Blood.NORMAL_BLOOD;
                prize = Prize.NORMAL_PRIZE;
                velocity = 1;
                w = 25;
                h = 30;
                break;
            case TANKER_ENEMY:
                blood = Blood.HIGH_BLOOD * 2;
                prize = Prize.HIGH_PRIZE * 2;
                velocity = 1;
        }
        initRoad();

    }
    protected abstract void initImage();
    protected abstract void showBlood(GraphicsContext gc);
    public void move(GraphicsContext gc) {
        posTarget();
        if(x < road.getX(pos)){
            x = x + vx;
            y = y + vy;
        }else{
            pos++;
        }

    }



    public void show(GraphicsContext gc){
        gc.drawImage(image,x,y,w,h);
        showBlood(gc);
    }

    public void show(GraphicsContext gc, long time){
        show(gc);
    }

    protected void posTarget(){
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

    private void initRoad(){
        int x = new Random().nextInt(2);
        if(x == 1){
            road = roadFirst;
        }else {
            road = roadSecond;
        }
    }


    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
    public double getX(){
        return x;
    }
    public void setBlood(int dame){
        this.blood -= dame;
    }
    public boolean isDead(){
        return blood <= 0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getY() {
        return y;
    }
}
