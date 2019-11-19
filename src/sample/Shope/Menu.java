package sample.Shope;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;
import sample.GameStage;
import sample.GameTile.GameTile;
import sample.GameTile.PosTower;
import sample.GameTile.Tower.*;

import java.util.ArrayList;

public class Menu implements GameTile {
    public static int MENU_HEIGHT = 60;
    private double x,y = GameStage.MAX_HEIGHT - MENU_HEIGHT;
    private Image image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\menu.png");
    private ArrayList<Item> items;
    public boolean openMenu = false;
    public Menu(){
        items = new ArrayList<>();
        init();
    }
    private void init(){
        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemMagicTower.png", TypeOfTower.MagicTower));
        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemNormalTower.png", TypeOfTower.NormalTower));
        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemStoneTower.png", TypeOfTower.StoneTower));
    }
    public Tower buildTower(int x, int y, Coin coin){
        Tower tower = null;
        if(openMenu){
            for(Item item : items){
                double xLo = item.x;
                double xHi = item.x + Item.WIDTH_ITEM;
                double yLo = item.y;
                double yHi = item.y + Item.HEIGHT_ITEM;
                if(xLo < x && x < xHi && yLo < y && y < yHi){
                    if(!coin.buyItem(item)){
                        return null;
                        //khong du tien mua item
                    }
                    switch (item.type){
                        case NormalTower:{
                            tower = new NormalTower(PosTower.posX.get(PosTower.indexOfTower), PosTower.posY.get(PosTower.indexOfTower));
                            break;
                        }
                        case MagicTower:{
                            tower = new MagicTower(PosTower.posX.get(PosTower.indexOfTower), PosTower.posY.get(PosTower.indexOfTower));
                            break;
                        }
                        case StoneTower:{
                            tower = new StoneTower(PosTower.posX.get(PosTower.indexOfTower), PosTower.posY.get(PosTower.indexOfTower));
                            break;
                        }


                    }
                    PosTower.build();
                    break;
                }
            }
            openMenu = false;
        }
        return tower;
    }
    public void setXY(int x, int y){
        items.get(0).x = x;
        items.get(0).y = y - Item.HEIGHT_ITEM;
        for(int i = 1; i < items.size(); i++){
            items.get(i).x = items.get(i-1).x + Item.WIDTH_ITEM;
            items.get(i).y = y - Item.HEIGHT_ITEM;
        }
    }
    @Override
    public void show(GraphicsContext gc) {
        gc.drawImage(image,0,GameStage.MAX_HEIGHT - MENU_HEIGHT, GameStage.MAX_WIDTH,MENU_HEIGHT);
        if(openMenu){
            for(Item item: items){
                item.show(gc);
            }
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
