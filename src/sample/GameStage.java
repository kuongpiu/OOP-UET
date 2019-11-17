package sample;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.stage.Stage;



public class GameStage {
    public static final int MAX_WIDTH = 720, MAX_HEIGHT = 466;
    private Stage stage;
    private Scene scene;
    private Group root;
    private Canvas canvas;
    public static Light.Point curMouse = new Light.Point();
    public GameStage(Stage stage){
        this.stage = stage;
        initStage();
    }
    private void initStage(){

        root = new Group();
        scene = new Scene(root);
        canvas = new Canvas(MAX_WIDTH, MAX_HEIGHT);
        root.getChildren().add(canvas);

        stage.setTitle("Tower Defense");

        stage.setResizable(false);
    }
    public void play(){
        MainGame game = new MainGame();
        game.play(this);
    }


    public Scene getScene() {
        return scene;
    }

    public GraphicsContext getGC() {
        return canvas.getGraphicsContext2D();
    }
    public void show(Scene scene){
        stage.setScene(scene);
        stage.show();
    }
}
