package sample.Player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.GameField;
import sample.Shop.Item;

public class Player {
    private Image imageHeart;
    private int hp;
    private Coin coin;

    public Player() {
        hp = 100;
        imageHeart = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\blood.png");
        coin = new Coin();
    }

    public boolean buyItem(Item item) {
        if(item == null){
            return false;
        }
        boolean success = coin.isEnough(item.getCost());
        if (success) {
            coin.subCoin(item.getCost());
        }
        return success;
    }

    public void bonus(int prize) {
        coin.bonus(prize);
    }

    public void show(GraphicsContext gc) {
        coin.show(gc);
        showBlood(gc);
    }

    private void showBlood(GraphicsContext gc) {
        gc.drawImage(imageHeart, 0, 0);
        gc.setFill(Color.RED);
        gc.setFont(Font.font("Verdana", 20));
        gc.fillText(Integer.toString(hp), 60, 30);
    }
}
