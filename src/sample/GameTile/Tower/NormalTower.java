package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.EnemyCode.Enemy;
import sample.GameField;

public class NormalTower extends Tower{
    public static double
            NORMAL_TOWER_WIDTH = 60,
            NORMAL_TOWER_HEIGHT = 70,
            RANGE = 200;
    ;
    private Image[] step = new Image[2];
    public NormalTower(int x, int y){
        super(TypeOfTower.NormalTower, x, y);
        step[0] = GameField.loadImage("C:\\Users\\Cuong\\Desktop\\OOP-UET\\src\\picture\\linh1.png");
        step[1] = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\linh5.png");
    }




    public void show(GraphicsContext gc, long time) {

        Image tower = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\betru.png");
        Image spider;
        if(time % 2 == 0){
            spider = step[0];
        }else{
            spider = step[1];
        }

        gc.drawImage(tower,x,y,w,h);
        gc.drawImage(spider,x+20,y-10);


    }

    public static void showInfo(double x, double y, GraphicsContext gc){
        gc.setGlobalAlpha(0.7);
        //TOA DO NGUOI BAN TEN
        double posSpinerX = x + 18;
        double posSpinerY = y - 10;
        gc.drawImage(GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\betru.png"), x,y,NORMAL_TOWER_WIDTH,NORMAL_TOWER_HEIGHT);
        gc.drawImage(GameField.loadImage("C:\\Users\\Cuong\\Desktop\\OOP-UET\\src\\picture\\linh1.png"), posSpinerX, posSpinerY);
        //PHAM VI BAN CUA THAP
        //TOA DO CUA HINH TRON
        double centerX = (x + NORMAL_TOWER_WIDTH/2) - RANGE/2;
        double centerY = (y + NORMAL_TOWER_HEIGHT/2) - RANGE/2;

        gc.setGlobalAlpha(0.3);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1);

        gc.fillOval(centerX,centerY,RANGE,RANGE);
        gc.strokeOval(centerX,centerY,RANGE,RANGE);


        gc.setGlobalAlpha(1);
    }


}
