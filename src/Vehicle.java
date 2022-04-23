import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.Move;

public class Vehicle extends Move {
    protected Image feature;
    protected Color color;

    public Vehicle() {}

    public Vehicle(Image feature, Color color) {
        this.feature = feature;
        this.color = color;
    }

    //not defined yet
    @Override
    public Node draw() {
        return super.draw();
    }
}
