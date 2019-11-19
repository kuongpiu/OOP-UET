package sample.GameTile;

import java.util.ArrayList;
import java.util.Random;

public class Road{
    public ArrayList<Double> posX;
    public ArrayList<Double> posY;
    private ArrayList<Double> road1X = new ArrayList<>();
    private ArrayList<Double> road2X = new ArrayList<>();
    private ArrayList<Double> road1Y = new ArrayList<>();
    private ArrayList<Double> road2Y = new ArrayList<>();


    public Road(int num){
        loadRoadFirst();
        loadRoadSecond();
        if(num == 1){
            posX = road1X;
            posY = road1Y;
        }else{
            posX = road2X;
            posY = road2Y;
        }
    }
    private void loadRoadFirst(){
        road1X.add(35.d);
        road1X.add(65.d);
        road1X.add(125.d);
            road1X.add(225.d);
        road1X.add(390.d);
        road1X.add(440.d);
            road1X.add(450.d);
        road1X.add(550.d);
        road1X.add(720.d);

        road1Y.add(400.d);
        road1Y.add(380.d);
        road1Y.add(355.d);
            road1Y.add(260.d);
        road1Y.add(260.d);
        road1Y.add(215.d);
            road1Y.add(130.d);
        road1Y.add(42.d);
        road1Y.add(190.d);
    }
    private void loadRoadSecond(){
        road2X.add(35.d);
        road2X.add(65.d);
        road2X.add(125.d);
        road2X.add(225.d);
        road2X.add(226.d);//posX.add(390.d);
        road2X.add(280.d);//posX.add(440.d);
        road2X.add(450.d);
        road2X.add(550.d);
        road2X.add(720.d);

        road2Y.add(400.d);
        road2Y.add(380.d);
        road2Y.add(355.d);
        road2Y.add(260.d);
        road2Y.add(160.d);//posY.add(260.d);
        road2Y.add(140.d);//posY.add(215.d);
        road2Y.add(130.d);
        road2Y.add(42.d);
        road2Y.add(190.d);
    }
    public double getX(int pos) {
        return posX.get(pos);
    }

    public double getY(int pos) {
        return posY.get(pos);
    }

}
