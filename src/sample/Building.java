package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.Random;
import java.util.Vector;

public class Building extends Change {
    protected  static Building[][] buildingMat = new Building[27][27];
    protected Terminal whichTerminal;
    protected int relativePosition;
    protected Color color;
    protected int height;
    protected Random random = new Random();
    protected static Vector<Pair<Integer,Integer>> Road = new Vector<>();
    //Note notes
    protected Image img;
    public static void init(){
        //Col , Row
        Road.add(new Pair<>(12,3));
        Road.add(new Pair<>(12,7));
        Road.add(new Pair<>(12,7));
        Road.add(new Pair<>(12,11));
        Road.add(new Pair<>(12,15));
        Road.add(new Pair<>(12,16));
        Road.add(new Pair<>(12,25));
        Road.add(new Pair<>(10,25));
        Road.add(new Pair<>(13,25));
        Road.add(new Pair<>(14,25));
        Road.add(new Pair<>(8,24));
        Road.add(new Pair<>(2,18));
        Road.add(new Pair<>(7,23));
        Road.add(new Pair<>(6,22));
        Road.add(new Pair<>(4,20));
        Road.add(new Pair<>(3,19));
        Road.add(new Pair<>(2,14));
        Road.add(new Pair<>(2,13));
        Road.add(new Pair<>(3,13));
        Road.add(new Pair<>(4,13));
        Road.add(new Pair<>(6,13));
        Road.add(new Pair<>(7,13));
        Road.add(new Pair<>(8,12));
        Road.add(new Pair<>(8,11));
        Road.add(new Pair<>(9,10));
        Road.add(new Pair<>(10,9));
        Road.add(new Pair<>(11,9));
        Road.add(new Pair<>(13,9));
        Road.add(new Pair<>(14,9));
        Road.add(new Pair<>(15,9));
        Road.add(new Pair<>(16,9));
        Road.add(new Pair<>(15,8));
        //Col , Row
        Road.add(new Pair<>(15,9));
        Road.add(new Pair<>(19,12));
        Road.add(new Pair<>(20,12));
        Road.add(new Pair<>(19,12));
        Road.add(new Pair<>(15,14));
        Road.add(new Pair<>(15,13));
        Road.add(new Pair<>(16,13));
        Road.add(new Pair<>(18,13));
        Road.add(new Pair<>(19,13));
        Road.add(new Pair<>(20,13));
        Road.add(new Pair<>(22,13));
        Road.add(new Pair<>(22,12));
        Road.add(new Pair<>(23,13));
        Road.add(new Pair<>(23,12));
        Road.add(new Pair<>(24,13));
        Road.add(new Pair<>(24,12));
        Road.add(new Pair<>(16,8));
        Road.add(new Pair<>(20,14));
        Road.add(new Pair<>(20,15));
        Road.add(new Pair<>(20,16));
        Road.add(new Pair<>(20,17));
        Road.add(new Pair<>(14,18));
        Road.add(new Pair<>(13,18));
        Road.add(new Pair<>(11,18));
        Road.add(new Pair<>(10,18));
        Road.add(new Pair<>(9,18));
        Road.add(new Pair<>(9,19));
        Road.add(new Pair<>(13,19));
        Road.add(new Pair<>(14,20));
        Road.add(new Pair<>(11,25));
        Road.add(new Pair<>(14,8));
        Road.add(new Pair<>(3,18));
        Road.add(new Pair<>(4,19));

    }
    public Building(int height) {
        setHeight(height);
    }

    public Building(Terminal whichTerminal, int relativePosition, Color color, int height/*Note notes*/) {
        this.whichTerminal = whichTerminal;
        this.relativePosition = relativePosition;
        this.color = color;
        this.height = height;
    }

    @Override
    public Node draw() {
        return super.draw();
    }


    public void setHeight(int height) {
        this.height = height;
        int i = 1+Math.abs(random.nextInt())%6;
        String s = System.getProperty("user.dir");

        if(s.charAt(s.length()-1)=='c'){
            img = new Image("file:sample/photo/" + "house0"+height+"0"+ i+".png");//0
        }
        else{
            img = new Image("file:src/sample/photo/" + "house0"+height+"0"+ i+".png");//0
        }


    }
}
