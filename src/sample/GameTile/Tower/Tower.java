package sample.GameTile.Tower;

import sample.EnemyCode.Enemy;
import sample.GameField;
import sample.GameTile.GameTile;
import javafx.scene.canvas.GraphicsContext;

public abstract class Tower implements GameTile {
    public static final int FAST = 3, MEDIUM = 2, SLOW = 1;
    public static final int LARGE = 200, SMALL = 150;
    public static final int DAME_TO = 100, DAME_TB = 50, DAME_NHO = 30;
    protected int hitSpeed;
    protected int range;
    protected int dame;
    protected int x, y, w, h;
    protected boolean fire = false;
    protected Bullet bullet;
    public Tower(TypeOfTower type, int x, int y){
        switch (type){
            case NormalTower:{
                hitSpeed = MEDIUM;
                range = SMALL;
                dame = DAME_NHO;

                break;
            }
            case SniperTower:{
                hitSpeed = SLOW;
                range = LARGE;
                dame = DAME_TO;
                break;
            }
            case MachineGunTower:{
                hitSpeed = FAST;
                dame = DAME_TB;
                range = SMALL;
                break;
            }
        }
        fire = false;
        this.x = x;
        this.y = y;
        w = 60;
        h = 70;
        bullet = new Bullet(this);
    }
    abstract public void show(GraphicsContext gc);
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
    public void setFire(boolean fire){
        this.fire = fire;
    }
    public boolean getFire(){
        return fire;
    }

    public boolean inRange(Enemy enemy){
        double px = enemy.getX() - this.getX();
        double py = enemy.getY() - this.getY();
        double distance = px*px + py*py;
        distance = Math.sqrt(distance);
        if(distance <= this.getRange()){
            return true;
        }else{
            return false;
        }
    }

    public void reset(){

    }





    public int getRange() {
        return range;
    }
}
