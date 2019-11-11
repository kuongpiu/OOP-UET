package sample.GameTile;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

public interface GameTile extends GameEntity {

    abstract void show(GraphicsContext gc);
}
