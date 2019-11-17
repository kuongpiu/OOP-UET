package sample;

import sample.GameTile.PosTower;
import sample.GameTile.Road;

import sample.GameTile.Tower.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Item.Menu;

import java.util.ArrayList;
import java.util.List;


public class MapGame {
    private Image background;
    private Road road;
    private PosTower posOfBuild;
    private List<Tower> towers;
    public MapGame(){
        background = GameField.loadImage("D:\\Github\\OOP-UET\\background.jpg");
        road = new Road();
        posOfBuild = new PosTower();
        towers = new ArrayList<>();
    }
    private void loadBG(GraphicsContext gc){

        gc.drawImage(background, 0,0,GameStage.MAX_WIDTH,GameStage.MAX_HEIGHT - Menu.MENU_HEIGHT);

    }

    public void show(GameStage gameStage){
        loadBG(gameStage.getGC());
        posOfBuild.show(gameStage.getGC());
    }

    public Road getRoad(){
        return road;
    }
}
