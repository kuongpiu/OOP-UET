package sample.GameTile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameField;
import sample.GameStage;

import java.util.Arrays;
import java.util.List;

public class PosTower{
    private static final Integer[] X = {60  ,180  ,403 ,560, 140, 165, 260, 465};
    private static final Integer[] Y = {245 ,316  ,11  ,60,  172, 45,  250, 222};

    public static List<Integer> posX = Arrays.asList(X);
    public static List<Integer> posY = Arrays.asList(Y);
    public static boolean[] isBuild = new boolean[posX.size()];
    public static final int WIDTH_RECTANGLE = 60, HEIGHT_RECTANGLE = 30;

    public static int indexOfTower = 0;

    public static final int[][] areaBuild = {
            {57,285},
            {175,360},
            {392,48},
            {541,100},
            {136,210},
            {160,85},
            {255,290},
            {460,262}

    };
    public static void build(){
        isBuild[indexOfTower] = true;
    }
    public static boolean isContains(double x, double y){
        boolean contain = false;
        for(int i = 0; i < areaBuild.length; i++){
            int begX = areaBuild[i][0];
            int endX = begX + WIDTH_RECTANGLE;
            int begY = areaBuild[i][1];
            int endY = begY + HEIGHT_RECTANGLE;
            if(begX <= x && x <= endX && begY <= y && y <= endY){
                indexOfTower = i;
                contain = true;
                break;
            }
        }
        return contain;
    }

    public void show(GraphicsContext gc){
        Image buildIcon = GameField.loadImage("C:\\Users\\Cuong\\Desktop\\OOP-UET\\src\\picture\\build.png");
        int x = (int) GameStage.curMouse.getX();
        int y = (int)GameStage.curMouse.getY();
        if(isContains(x,y) == true){
            if(!isBuild[indexOfTower]){
                gc.drawImage(buildIcon,posX.get(indexOfTower), posY.get(indexOfTower));
            }
        }
    }

}
