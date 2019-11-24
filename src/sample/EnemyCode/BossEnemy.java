package sample.EnemyCode;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.GameField;

public class BossEnemy extends Enemy {
    public static double WIDTH = 40, HEIGHT = 50, VELOCITY = 0.5, BLOOD = 300, PRIZE = 100;
    public BossEnemy(){
        super(TypeEnemy.BOSS_ENEMY);
        initImage();
    }

    @Override
    protected void initImage() {
        if(x % 2 == 0){
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\boss.png");
        }else{
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\boss1.png");
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
