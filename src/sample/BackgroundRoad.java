package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class BackgroundRoad extends Segment{
    protected Color color;
    protected String feature;

    public BackgroundRoad() {}

    public BackgroundRoad(Color color, String feature) {
        this.color = color;
        this.feature = feature;
    }

    //not defined yet
    @Override
    public Node draw() {
        return super.draw();
    }
}
