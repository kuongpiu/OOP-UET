package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class GameStart {
    private Image image;
    private boolean gamePause = false;
    private boolean gameStart = false;
    private Group group;
    private Canvas canvas;
    public static double mouseX = 0,mouseY = 0;
    public GameStart(){
        image = GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\startImgae.png");
        gamePause = false;
        group = new Group();
        canvas = new Canvas(GameStage.MAX_WIDTH, GameStage.MAX_HEIGHT);
        group.getChildren().add(canvas);

    }
    private void loadImage(GraphicsContext gc){
        gc.drawImage(image,0,0,GameStage.MAX_WIDTH, GameStage.MAX_HEIGHT);
        if(moveInButton(mouseX,mouseY)){
            gc.drawImage(GameField.loadImage("D:\\Github\\OOP-UET\\src\\picture\\button.png"), 280,308, 155,40);
        }
    }
    public void start(GameStage gameStage){
        gameStage.setGroup(group);
        setMouseMove(gameStage.getScene());
        LoopGame(gameStage);

    }

    private void LoopGame(GameStage gameStage){

        new AnimationTimer(){

            @Override
            public void handle(long l) {
                loadImage(canvas.getGraphicsContext2D());
                checkedClick(gameStage.getScene());
                if(gameStart){
                    new MainGame().play(gameStage);
                    this.stop();
                }
                //System.out.println("123");
            }

        }.start();
        if(!gameStart)
            gameStage.show();
    }
    private void checkedClick(Scene scene){
        // 277 350;
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(moveInButton(mouseEvent.getX(),mouseEvent.getY())){
                    gameStart = true;
                }else{
                    gameStart = false;
                }
            }
        });

    }
    private void setMouseMove(Scene scene){
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseX = mouseEvent.getX();
                mouseY = mouseEvent.getY();
                System.out.println(mouseX + " " + mouseY);
            }
        });
    }
    private boolean moveInButton(double mouseX, double mouseY){
        if(mouseX >= 277 && mouseX <= 434 && mouseY >= 290 && mouseY <= 340){
            return true;
        }else{
            return false;
        }
    }
}
