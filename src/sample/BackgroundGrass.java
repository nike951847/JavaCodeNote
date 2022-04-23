package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class BackgroundGrass extends Segment{
    protected Color color;
    protected String feature;

    public BackgroundGrass() {}

    public BackgroundGrass(Color color, String feature) {
        this.color = color;
        this.feature = feature;
    }

    //not defined yet
    @Override
    public Node draw() {
        return super.draw();
    }
}
