package sample.Shop;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameTile.GameTile;

public class ButtonItem implements GameTile {
    private Image image;
    private double x,y,w,h;
    public ButtonItem(Image image, double w, double h){
        this.image = image;
        this.w = w;
        this.h = h;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void show(GraphicsContext gc) {
        gc.drawImage(image,x,y,w,h);
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
