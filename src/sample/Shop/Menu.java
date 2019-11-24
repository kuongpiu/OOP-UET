package sample.Shop;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import sample.GameField;
import sample.GameStage;
import sample.GameTile.GameTile;
import sample.GameTile.PosTower;
import sample.GameTile.Tower.*;
import sample.Player.Player;

import java.util.ArrayList;

public class Menu implements GameTile {
    private ArrayList<Item> items;
    public boolean openMenu = false;
    public boolean buyItem = false;
    private ButtonItem exit = new ButtonItem( GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\escape.png"),
            Item.WIDTH_ITEM,
            Item.HEIGHT_ITEM
    );
    public Menu(){
        items = new ArrayList<>();
        init();
    }
    private void init(){


        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemMagicTower1.png", TypeOfTower.MagicTower));
        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemNormal.png", TypeOfTower.NormalTower));
        items.add(new Item("D:\\Github\\OOP-UET\\src\\picture\\itemStone.png", TypeOfTower.StoneTower));

    }
    public Tower buildTower(double x, double y,Player player){
        Tower tower = null;
        if(buyItem){
            buyItem = false;
            openMenu = false;
            Item item = getItem(x,y);
            if(!player.buyItem(item)){
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
        exit.setXY(items.get(items.size()-1).getX(),
                items.get(items.size()-1).getY() + Item.HEIGHT_ITEM
        );

    }
    @Override
    public void show(GraphicsContext gc) {
        if(openMenu){
            for(Item item: items){
                item.show(gc);
            }
            exit.show(gc);
        }
    }
    public void preView(GraphicsContext gc){
        if(openMenu){
            double x = GameStage.curMouse.getX();
            double y = GameStage.curMouse.getY();
            Item item = getItem(x,y);
            if(item != null){
                switch (item.type){
                    case MagicTower:{
                        MagicTower.showInfo(PosTower.posX.get(PosTower.indexOfTower),
                                PosTower.posY.get(PosTower.indexOfTower),
                                gc
                        );
                        break;
                    }

                    case NormalTower:{
                        NormalTower.showInfo(PosTower.posX.get(PosTower.indexOfTower),
                                PosTower.posY.get(PosTower.indexOfTower),
                                gc
                        );
                        break;
                    }

                    case StoneTower:{
                        StoneTower.showInfo(PosTower.posX.get(PosTower.indexOfTower),
                                PosTower.posY.get(PosTower.indexOfTower),
                                gc
                        );
                    }
                }
            }
        }
    }
    private Item getItem(double x, double y){
        for(Item item: items){
            double xLo = item.x;
            double xHi = item.x + Item.WIDTH_ITEM;
            double yLo = item.y;
            double yHi = item.y + Item.HEIGHT_ITEM;
            if(xLo < x && x < xHi && yLo < y && y < yHi){
                return item;
            }
        }
        return null;
    }
    public boolean isBuy(double x, double y){
        for(Item item: items){
            double xLo = item.x;
            double xHi = item.x + Item.WIDTH_ITEM;
            double yLo = item.y;
            double yHi = item.y + Item.HEIGHT_ITEM;
            if(xLo < x && x < xHi && yLo < y && y < yHi){
                return true;
            }
        }
        //KIEM TRA XEM CO THOAT MENU KHONG
        if(x > exit.getX() && x < exit.getX()+Item.WIDTH_ITEM
            && y > exit.getY() && y < exit.getY()+Item.HEIGHT_ITEM){
            openMenu = false;
            System.out.println("yeyeyeyeyye");
        }
        System.out.println("Noonono");
        return false;
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
