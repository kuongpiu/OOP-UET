package sample.Shope;

import javafx.scene.canvas.GraphicsContext;

public class Coin {
    private long balance;
    public Coin(){
        balance = 100;
    }
    public void bonus(int coin){
        balance += coin;
    }
    private boolean isEnough(int cost){
        return balance >= cost;
    }
    private void subCoin(int sub){
        balance -= sub;
    }
    public boolean buyItem(Item item){
        boolean success = false;
        if(isEnough(item.getCost())){
            System.out.println("mua thanh cong");
            subCoin(item.getCost());
            success = true;
        }else {
            System.out.println("so tien cua ban khong du de mua vat pham nay");

        }
        return success;
    }
    public void show(GraphicsContext gc){
        gc.fillText("coin: ", 0,430);
    }
}
