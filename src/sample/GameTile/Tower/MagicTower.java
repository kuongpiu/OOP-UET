package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.GameField;
import sample.GameStage;
import sample.GameTile.PosTower;

public class MagicTower extends Tower {
    public static double
            MAGIC_TOWER_WIDTH = 50,
            MAGIC_TOWER_HEIGHT = 70,
            RANGE = 100;
    ;
    public MagicTower(int x, int y) {
        super(TypeOfTower.MagicTower, x, y);
    }
    public static void showInfo(double x, double y, GraphicsContext gc){
        gc.setGlobalAlpha(0.7);
        gc.drawImage(GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\magicTower1.png"), x,y,MAGIC_TOWER_WIDTH,MAGIC_TOWER_HEIGHT);
        //PHAM VI BAN CUA THAP
        //TOA DO CUA HINH TRON
        double centerX = (x + MAGIC_TOWER_WIDTH/2) - RANGE;
        double centerY = (y + MAGIC_TOWER_HEIGHT/2) - RANGE;

        gc.setGlobalAlpha(0.3);
        gc.setFill(Color.PINK);
        gc.setLineWidth(1);

        gc.fillOval(centerX,centerY,2*RANGE,2*RANGE);
        gc.strokeOval(centerX,centerY,2*RANGE,2*RANGE);


        gc.setGlobalAlpha(1);
    }
}





