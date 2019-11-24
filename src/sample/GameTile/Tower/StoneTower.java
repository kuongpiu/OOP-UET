package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.GameField;

public class StoneTower extends Tower {
    public static double
            STONE_TOWER_WIDTH = 50,
            STONE_TOWER_HEIGHT = 65,
            RANGE = 150;
    ;
    public StoneTower(int x, int y) {
        super(TypeOfTower.StoneTower, x, y);
    }

    public static void showInfo(double x, double y, GraphicsContext gc){
        gc.setGlobalAlpha(0.8);
        gc.drawImage(GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\da1.png"), x,y,STONE_TOWER_WIDTH,STONE_TOWER_HEIGHT);
        //PHAM VI BAN CUA THAP
        //TOA DO CUA HINH TRON
        double centerX = (x + STONE_TOWER_WIDTH/2) - RANGE;
        double centerY = (y + STONE_TOWER_HEIGHT/2) - RANGE;

        gc.setGlobalAlpha(0.2);
        gc.setFill(Color.BROWN);
        gc.setLineWidth(1);

        gc.fillOval(centerX,centerY,2*RANGE,2*RANGE);
        gc.strokeOval(centerX,centerY,2*RANGE,2*RANGE);


        gc.setGlobalAlpha(1);
    }
}
