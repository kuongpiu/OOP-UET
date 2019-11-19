package sample.EnemyCode;

import sample.GameTile.Road;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;

import java.util.Random;

public class NormalEnemy extends Enemy {
    public NormalEnemy(){
        super(TypeEnemy.NORMAL_ENEMY);
        initImage();
    }
    protected void initImage(){
        if(x % 2 == 0){
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\normalEnemy1.png");
        }else{
            image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\normalEnemy2.png");
        }
    }

    @Override
    protected void showBlood(GraphicsContext gc) {
        double k = Blood.NORMAL_BLOOD/(double)w;
        double width = blood/k;

        gc.beginPath();
        gc.moveTo(x,y);
        gc.lineTo(x+width,y);
        gc.closePath();
        gc.stroke();
    }
}
