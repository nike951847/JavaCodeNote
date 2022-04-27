package sample;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Segment {
    protected Point2D position;

    public Segment(Point2D position) {
        this.position = position;
    }

    public Segment(double x, double y) {
        position = new Point2D(x, y);
    }

    public Segment() {
        position = new Point2D(0.0, 0.0);
    }

    public Node draw() {
        Node rt = new Node() {};
        return rt;
    }

    public void setPoint(double x, double y) {
        position = new Point2D(x,y);
    }

    public Point2D getPosition() {
        return position;
    }
}
