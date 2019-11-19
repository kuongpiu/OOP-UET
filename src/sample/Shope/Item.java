package sample.Shope;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;
import sample.GameTile.GameTile;
import sample.GameTile.Tower.TypeOfTower;

public class Item implements GameTile {
    private Image image;
    private int cost = 100;
    public double x,y;
    public static final int WIDTH_ITEM = 50;
    public static final int HEIGHT_ITEM = 50;
    public TypeOfTower type;


    public Item(Image image, double x, double y){
        this.image = image;
        this.x = x;
        this.y = y;

    }
    public Item(String str, double x, double y){
        this.image = GameField.loadImage(str);
        this.x = x;
        this.y = y;

    }
    public Item(String str, TypeOfTower type){
        this.image = GameField.loadImage(str);
        this.type = type;

    }
    public int getCost(){
        return cost;
    }
    @Override
    public void show(GraphicsContext gc) {
            gc.drawImage(image,x,y,WIDTH_ITEM,HEIGHT_ITEM);

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

}
