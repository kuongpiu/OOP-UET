package sample.EnemyCode;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.GameField;
import sample.GameStage;
import sample.GameTile.Road;
import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;
import sample.GameTile.Tower.NormalTower;

import java.util.Random;

public abstract class Enemy implements GameEntity {
    final private Road roadFirst = new Road(1);
    final private Road roadSecond = new Road(2);

    protected double x,y,vx,vy;
    protected double w,h;
    protected double blood, prize, velocity;
    protected int pos = 0;
    protected Image image;

    protected Road road;

    public Enemy(TypeEnemy type){
        x = new Random().nextInt(200)  - 250;
        y = new Random().nextInt(200) + GameStage.MAX_HEIGHT + 20;
        switch (type){
            case SMALLER_ENEMY:
                blood = SmallerEnemy.BLOOD;
                prize = SmallerEnemy.PRIZE;
                w = SmallerEnemy.WIDTH;
                h = SmallerEnemy.HEIGHT;
                velocity = SmallerEnemy.VELOCITY;
                break;
            case BOSS_ENEMY:
                blood = BossEnemy.BLOOD;
                prize = BossEnemy.PRIZE;
                w = BossEnemy.WIDTH;
                h = BossEnemy.HEIGHT;
                velocity = BossEnemy.VELOCITY;
                break;
            case NORMAL_ENEMY:
                blood = NormalEnemy.BLOOD;
                prize = NormalEnemy.PRIZE;

                w = NormalEnemy.WIDTH;
                h = NormalEnemy.HEIGHT;
                velocity = NormalEnemy.VELOCITY;
                break;

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

    protected void dinhDang(GraphicsContext gc, double dodai){
        gc.setLineWidth(1);
        if(dodai < w/2){
            gc.setStroke(Color.RED);
        }else{
            gc.setStroke(Color.GREEN);
        }
    }


    public double getW() {
        return w;
    }

    public double getH() {
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
    public double getPrize(){
        return prize;
    }
}
