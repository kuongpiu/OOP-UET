package sample.EnemyCode;

import javafx.scene.canvas.GraphicsContext;
import sample.GameField;

public class BossEnemy extends Enemy {
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
        double k = Blood.HIGH_BLOOD/(double)w;
        double width = blood/k;

        gc.beginPath();
        gc.moveTo(x,y);
        gc.lineTo(x+width,y);
        gc.closePath();
        gc.stroke();
    }
}
