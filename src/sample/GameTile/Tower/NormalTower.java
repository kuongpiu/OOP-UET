package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.GameField;

public class NormalTower extends Tower{
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

}
