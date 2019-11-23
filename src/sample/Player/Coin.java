package sample.Player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.GameField;

public class Coin {
    private long balance;
    private Image imageCoin;
    public Coin(){
        balance = 100;
        imageCoin = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\work.png");
    }
    public void bonus(int coin){
        balance += coin;
    }
    public boolean isEnough(int cost){
        return balance >= cost;
    }
    public void subCoin(int sub){
        balance -= sub;
    }

    public void show(GraphicsContext gc){
        gc.drawImage(imageCoin, 120,0);
        showCoin(gc);
    }
    private void showCoin(GraphicsContext gc){
        gc.setFill(Color.BLUE);
        gc.setFont(Font.font("Verdana", 15));
        gc.fillText(Long.toString(balance), 165,30);
    }
}
