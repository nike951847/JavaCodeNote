package sample;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.util.Duration;

public class Move extends Segment{
    protected ArrayList<LineTo> path;
    protected double pace;//or maybe double?
    protected PathTransition pathTransition = new PathTransition();
    /*
    return the next point
     public Point2D update() {
         if(path.indexOf(position) == path.size())
             return path.get(0);
         else
             return path.get(path.indexOf(position)+1);
     }
    */

    public void addPath(int x,int y) {
        //not sure if "new" is needed
        path.add(new LineTo(x,y));
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public double getPace() {
        return pace;
    }
}
