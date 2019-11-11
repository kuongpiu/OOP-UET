package sample.GameTile;

import java.util.ArrayList;

public class Road{
    public ArrayList<Double> posX;
    public ArrayList<Double> posY;
    public Road(){
        posX = new ArrayList<>();
        posY = new ArrayList<>();
        init();
    }
    private void init(){
        posX.add(35.d);
        posX.add(65.d);
        posX.add(125.d);
        posX.add(225.d);
        posX.add(390.d);
            posX.add(440.d);
        posX.add(450.d);
        posX.add(550.d);
        posX.add(720.d);

        posY.add(400.d);
        posY.add(380.d);
        posY.add(355.d);
        posY.add(260.d);
        posY.add(260.d);
            posY.add(215.d);
        posY.add(130.d);
        posY.add(42.d);
        posY.add(190.d);
    }
    public double getX(int pos) {
        return posX.get(pos);
    }

    public double getY(int pos) {
        return posY.get(pos);
    }

}
