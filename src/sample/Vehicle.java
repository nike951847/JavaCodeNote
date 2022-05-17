package sample;

import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Vector;

public class Vehicle extends Move {
    public static Vector<Vehicle> vehicles = new Vector<>();
    protected String feature;
    protected String color;
    protected Image img;
    protected ImageView imageView;
    public static void init(){
        vehicles.add(new Vehicle("MRT", "RED"));
        vehicles.get(0).setMoveTo(252, 657);
        vehicles.get(0).addPath(730,666);
        vehicles.get(0).addPath(982,480);
        vehicles.get(0).addPath(1700,410);
        vehicles.get(0).pace = 15;
        vehicles.add(new Vehicle("MRT", "RED"));
        vehicles.get(1).setMoveTo(250, 864);
        vehicles.get(1).addPath(940,1220);
        vehicles.get(1).addPath(1527,1205);
        vehicles.get(1).pace = 10;
        vehicles.add(new Vehicle("MRT", "RED"));
        vehicles.get(2).setMoveTo(1732,637);
        vehicles.get(2).addPath(2453,624);
        vehicles.get(2).addPath(2548, 588);
        vehicles.get(1).pace = 7;
        for(Vehicle v: vehicles){
            v.setTrans(new PathTransition(Duration.seconds(v.pace),v.path));
            v.pathTransition.setNode(v.imageView);
            v.pathTransition.setAutoReverse(true);
            v.pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            v.pathTransition.setCycleCount(2100);
        }
    }


    public Vehicle(String feature, String color) {
        this.feature = feature;
        this.color = color;
        String s = System.getProperty("user.dir");
        if(s.charAt(s.length()-1)=='c'){
           img = new Image("file:sample/photo/" +feature + color+ ".png");//0
        }
        else{
           img = new Image("file:src/sample/photo/" + feature+color + ".png");//0
        }
        imageView = new ImageView(img);
        imageView.setFitHeight(40);
        imageView.setFitWidth(120);
    }

    //not defined yet
    @Override
    public Node draw() {
        return super.draw();
    }
}
