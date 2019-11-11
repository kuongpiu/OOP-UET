package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.GameField;

public class Bullet {
    private double x,y,w,h;
    private double vx,vy,velocity = 4;
    private Image image;
    public boolean hit = false;
    public Bullet(Tower tower){
        this.x = tower.getX();
        this.y = tower.getY();
        image = GameField.loadImage("C:\\Users\\Cuong\\Desktop\\OOP-UET\\src\\picture\\build.png");
        w = 40;
        h = 40;
    }
    private void setVelocity(Enemy enemy){
        vx = enemy.getX() - x;
        vy = enemy.getY() - y;
        double sum = vx*vx + vy*vy;
        sum = Math.sqrt(sum);
        vx /= sum;
        vy /= sum;
        vx *= velocity;
        vy *= velocity;
    }
    public boolean fly(Enemy enemy,GraphicsContext gc){
        setVelocity(enemy);
        if(enemy.getX() <= x && x <= enemy.getX() + enemy.getW() && enemy.getY() <= y && y <= enemy.getY() + enemy.getH()){
            return true;
        }else{
            gc.drawImage(image,x,y,w,h);
            x += vx;
            y += vy;
        }
        return hit;
    }




}

/*
private int x, y,w,h,wE,hE;
    private int vx,vy;
    private int velocity = 4;
    private Image image;
    private boolean tick = false;
    private Enemy enemy;
    public Bullet(int x, int y, Image image, Enemy enemy){
        wE = enemy.getW();
        hE = enemy.getH();
        w = 40;
        h = 60;
        this.x = x;
        this.y = y;
        this.image = image;
        this.enemy = enemy;
        setVelocity((int)enemy.getX(),(int)enemy.getY());
    }
    public void setVelocity(int tx, int ty){
        vx = tx - x;
        vy = ty - y;
        double sum = vx*vx + vy*vy;
        sum = Math.sqrt(sum);
        vx /= sum;
        vy /= sum;
        vx *= velocity;
        vy *= velocity;
    }
    public boolean move(GraphicsContext gc){
        if(x >= enemy.getX() && x <= enemy.getX()+ enemy.getW() && y >= enemy.getY() && y <= enemy.getY()+ enemy.getH()){
            return true;
        }
        x += vx;
        y += vy;
        show(gc);
        return false;
    }
    public boolean BulletHit(){
        return tick;
    }

    public void show(GraphicsContext gc){
        if(!tick){
            gc.drawImage(image,x,y,w,h);
        }
    }



 */
