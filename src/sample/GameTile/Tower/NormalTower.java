package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.EnemyCode.Enemy;
import sample.GameField;

public class NormalTower extends Tower{
    public static double
            NORMAL_TOWER_WIDTH = 50,
            NORMAL_TOWER_HEIGHT = 70,
            RANGE = 120;
    ;
    public NormalTower(int x, int y){
        super(TypeOfTower.NormalTower, x, y);

    }
    public static void showInfo(double x, double y, GraphicsContext gc){
        gc.setGlobalAlpha(0.7);

        gc.drawImage(GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\normalTower.png"), x,y,NORMAL_TOWER_WIDTH,NORMAL_TOWER_HEIGHT);

        //PHAM VI BAN CUA THAP
        //TOA DO CUA HINH TRON
        double centerX = (x + NORMAL_TOWER_WIDTH/2) - RANGE;
        double centerY = (y + NORMAL_TOWER_HEIGHT/2) - RANGE;

        gc.setGlobalAlpha(0.3);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1);

        gc.fillOval(centerX,centerY,2*RANGE,2*RANGE);
        gc.strokeOval(centerX,centerY,2*RANGE,2*RANGE);


        gc.setGlobalAlpha(1);
    }


}
