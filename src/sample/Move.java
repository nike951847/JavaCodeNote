package sample;

import java.util.ArrayList;
import javafx.geometry.Point2D;

public class Move extends Segment{
    protected ArrayList<Point2D> path;
    protected double pace;//or maybe double?

    //return the next point
    public Point2D update() {
        if(path.indexOf(new Point2D(position.getX(), position.getY())) == path.size())
            return path.get(0);
        else
            return path.get(path.indexOf(new Point2D(position.getX(), position.getY()))+1);
    }

    public void addPath(Point2D p) {
        //not sure if "new" is needed
        path.add(new Point2D(p.getX(), p.getY()));
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public double getPace() {
        return pace;
    }
}
