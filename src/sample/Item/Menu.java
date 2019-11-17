package sample.Item;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;
import sample.GameStage;
import sample.GameTile.GameTile;
import sample.GameTile.Tower.TypeOfTower;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu implements GameTile {
    public static int MENU_HEIGHT = 60;
    private double x,y = GameStage.MAX_HEIGHT - MENU_HEIGHT;
    private Image image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\menu.png");
    private ArrayList<Item> menu;
    public Menu(){
        menu = new ArrayList<>();
        init();
    }
    private void init(){
        menu.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemMagicTower.png", TypeOfTower.MagicTower));
        menu.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemNormalTower.png", TypeOfTower.NormalTower));
        menu.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemStoneTower.png", TypeOfTower.StoneTower));
        menu.get(0).x = 10;
        menu.get(0).y = y;
        for(int i = 1; i < menu.size(); i++){
            menu.get(i).x = menu.get(i-1).x + Item.WIDTH_ITEM;
            menu.get(i).y = y;
        }
    }

    @Override
    public void show(GraphicsContext gc) {
        gc.drawImage(image,0,GameStage.MAX_HEIGHT - MENU_HEIGHT, GameStage.MAX_WIDTH,MENU_HEIGHT);
        for(Item item: menu){
            item.show(gc);
        }
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }
}
