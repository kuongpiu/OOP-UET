package sample.EnemyCode;

import sample.GameTile.Road;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;

import java.util.Random;

public class NormalEnemy extends Enemy {
    public NormalEnemy(){
        super(TypeEnemy.NORMAL_ENEMY);
    }

    @Override
    public void move(GraphicsContext gc, Road road) {
        posTarget(road);
        if(x < road.getX(pos)){
            x = x + vx;
            y = y + vy;
        }else{
            pos++;
        }

    }
}
