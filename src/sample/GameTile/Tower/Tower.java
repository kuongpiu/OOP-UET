package sample.GameTile.Tower;

import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.GameField;
import sample.GameTile.GameTile;
import javafx.scene.canvas.GraphicsContext;

public abstract class Tower implements GameTile {
    public static final int FAST = 2, MEDIUM = 5, SLOW = 15;
    public static final int LARGE = 200, SMALL = 150;
    public static final int DAME_TO = 100, DAME_TB = 50, DAME_NHO = 30;
    protected int hitSpeed;
    protected long lasTime = 0;
    protected int range;
    protected int dame;
    protected int x, y, w, h;
    protected boolean fire = false;
    protected Bullet bullet;
    protected Image image;
    protected Image bulletImage;
    public Tower(TypeOfTower type, int x, int y) {
        switch (type) {
            case NormalTower: {
                hitSpeed = MEDIUM;
                range = SMALL;
                dame = DAME_NHO;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\betru.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\muiten.png");
                w = 60;
                h = 70;
                break;
            }
            case StoneTower: {
                hitSpeed = SLOW;
                dame = DAME_TB;
                range = SMALL;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\stoneTower.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\stone1.png");
                w = 50;
                h = 70;
                break;
            }
            case MagicTower: {
                hitSpeed = MEDIUM;
                dame = DAME_TB;
                range = LARGE;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\magicTower1.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\bulletMagic.png");
                w = 60;
                h = 70;
                break;
            }
        }
        fire = false;
        this.x = x;
        this.y = y;

    }

    public void show(GraphicsContext gc) {

        gc.drawImage(image,x,y,w,h);
    }

    @Override
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public boolean getFire() {
        return fire;
    }

    public boolean inRange(Enemy enemy) {
        double px = enemy.getX() - this.getX();
        double py = enemy.getY() - this.getY();
        double distance = px * px + py * py;
        distance = Math.sqrt(distance);
        if (distance <= this.getRange()) {
            return true;
        } else {
            return false;
        }
    }
    public void attack(GraphicsContext gc){
        boolean hit = bullet.attack(gc);
        if(hit == true){
            fire = false;
            bullet = null;
        }
    }
    public void attack(Enemy enemy, GraphicsContext gc){
        bullet = new Bullet(this, enemy);
        bullet.setImage(bulletImage);
        fire = true;
    }


    public long getLasTime(){
        return lasTime;
    }
    public void setLasTime(long lasTime){
        this.lasTime = lasTime;
    }
    public int getSpeed(){
        return hitSpeed;
    }




    public int getRange() {
        return range;
    }
}
