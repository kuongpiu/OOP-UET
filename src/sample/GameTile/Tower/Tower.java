package sample.GameTile.Tower;

import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.GameField;
import sample.GameTile.GameTile;
import javafx.scene.canvas.GraphicsContext;
import sample.GameTile.PosTower;

public abstract class Tower implements GameTile {
    public static final int FAST = 1, MEDIUM = 2, SLOW = 5;

    public static final int DAME_TO = 100, DAME_TB = 50, DAME_NHO = 30;
    protected int hitSpeed;
    protected long lasTime = 0;
    protected double range;
    protected int dame;
    protected double x, y, w, h;
    protected boolean fire = false;
    protected Bullet bullet;
    protected Image image;
    protected Image bulletImage;
    public Tower(TypeOfTower type, int x, int y) {
        switch (type) {
            case NormalTower: {
                hitSpeed = MEDIUM;
                range = NormalTower.RANGE;
                dame = DAME_NHO;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\normalTower.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\danXanh.png");
                w = NormalTower.NORMAL_TOWER_WIDTH;
                h = NormalTower.NORMAL_TOWER_HEIGHT;
                break;
            }
            case StoneTower: {
                hitSpeed = SLOW;
                dame = DAME_TB;
                range = StoneTower.RANGE;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\da1.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\stone.png");
                w = StoneTower.STONE_TOWER_WIDTH;
                h = StoneTower.STONE_TOWER_HEIGHT;
                break;
            }
            case MagicTower: {
                hitSpeed = MEDIUM;
                dame = DAME_TB;
                range = MagicTower.RANGE;
                image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\magicTower1.png");
                bulletImage = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\bulletMagic.png");
                w = MagicTower.MAGIC_TOWER_WIDTH;
                h = MagicTower.MAGIC_TOWER_HEIGHT;
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
    public void show(GraphicsContext gc, long time) {
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
    public boolean isFree(long curTime){
        long distance = curTime - lasTime;
        if(distance > hitSpeed){
            lasTime = curTime;
            return true;
        }else{
            return false;
        }
    }
    public double getRange(){
        return range;
    }

}
