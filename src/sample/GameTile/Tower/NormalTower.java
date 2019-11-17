package sample.GameTile.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.EnemyCode.Enemy;
import sample.GameField;

public class NormalTower extends Tower{

    public NormalTower(int x, int y){
        super(TypeOfTower.NormalTower, x, y);
    }



    public void show(GraphicsContext gc) {

        Image tower = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\betru.png");
        Image spider = GameField.loadImage("C:\\Users\\Cuong\\Desktop\\OOP-UET\\src\\picture\\linh1.png");

        gc.drawImage(tower,x,y,w,h);
        gc.drawImage(spider,x+20,y-10);


    }

}
