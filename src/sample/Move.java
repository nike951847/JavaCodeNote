package sample;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Move extends Segment{
    protected Path path =new Path();
    protected double pace = 5;//or maybe double?
    protected PathTransition pathTransition = new PathTransition();
    public void setMoveTo(int x,int y) {
        //not sure if "new" is needed

        path.getElements().add(new MoveTo(x,y));
    }
    public void addPath(int x,int y) {
        //not sure if "new" is needed

        path.getElements().add(new LineTo(x,y));
    }

    public void setTrans(PathTransition pathTransition1) {
        this.pathTransition = pathTransition1;
    }

    public double getPace() {
        return pace;
    }
}
