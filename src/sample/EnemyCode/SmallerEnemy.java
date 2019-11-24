package sample.EnemyCode;

import javafx.scene.canvas.GraphicsContext;
import sample.GameField;

public class SmallerEnemy extends Enemy {
    public static double WIDTH = 20, HEIGHT = 25, VELOCITY = 1, BLOOD = 50, PRIZE = 5;
    public SmallerEnemy(){
        super(TypeEnemy.SMALLER_ENEMY);
        initImage();
    }
    protected void initImage(){
        if(x % 2 == 0){
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\smallEnemy.png");
        }else{
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\smallEnemy2.png");
        }
    }
    protected void showBlood(GraphicsContext gc) {
        double k = BLOOD/(double)w;
        double width = blood/k;
        dinhDang(gc, width);
        gc.beginPath();
        gc.moveTo(x,y);
        gc.lineTo(x+width,y);
        gc.closePath();
        gc.stroke();
    }
}
