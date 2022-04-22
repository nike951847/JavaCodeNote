package sample;
//package javafx.scene.web;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import javafx.web.HTMLEditor;

public class Controller {


    @FXML
    private ImageView algorithmStation;

    @FXML
    private ImageView centralStation;

    @FXML
    private ImageView classStation;

    @FXML
    private ImageView dFS_BFSStation;

    @FXML
    private ImageView dataTypeStation;

    @FXML
    private ImageView distributedStation;

    @FXML
    private ImageView encapsulationStation;

    @FXML
    private ImageView exceptionStation;

    @FXML
    private ImageView gPUStation;

    @FXML
    private ImageView graphStation;

    @FXML
    private ImageView hashStation;

    @FXML
    private ImageView inheritanceStation;

    @FXML
    private ImageView interfaceStation;

    @FXML
    private ImageView mPIStation;

    @FXML
    private ImageView openMPStation;

    @FXML
    private ImageView polymorphismStation;

    @FXML
    private ImageView threadStation;

    @FXML
    private ImageView treeStation;

    @FXML
    private GridPane desktop;

    public void initialize() {
        {
            openMPStation.setImage(Main.imageVector.get(0));
            inheritanceStation.setImage(Main.imageVector.get(1));
            polymorphismStation.setImage(Main.imageVector.get(2));
            encapsulationStation.setImage(Main.imageVector.get(3));
            mPIStation.setImage(Main.imageVector.get(4));
            classStation.setImage(Main.imageVector.get(5));
            interfaceStation.setImage(Main.imageVector.get(6));
            exceptionStation.setImage(Main.imageVector.get(7));
            threadStation.setImage(Main.imageVector.get(8));
            centralStation.setImage(Main.imageVector.get(9));
            dFS_BFSStation.setImage(Main.imageVector.get(10));
            distributedStation.setImage(Main.imageVector.get(11));
            gPUStation.setImage(Main.imageVector.get(12));
            dataTypeStation.setImage(Main.imageVector.get(13));
            hashStation.setImage(Main.imageVector.get(14));
            treeStation.setImage(Main.imageVector.get(15));
            algorithmStation.setImage(Main.imageVector.get(16));
            graphStation.setImage(Main.imageVector.get(17));
        }

        {
            openMPStation.setFitHeight(40);
            inheritanceStation.setFitHeight(40);
            polymorphismStation.setFitHeight(40);
            encapsulationStation.setFitHeight(40);
            mPIStation.setFitHeight(40);
            classStation.setFitHeight(40);
            interfaceStation.setFitHeight(40);
            exceptionStation.setFitHeight(40);
            threadStation.setFitHeight(40);
            centralStation.setFitHeight(40);
            dFS_BFSStation.setFitHeight(40);
            distributedStation.setFitHeight(40);
            gPUStation.setFitHeight(40);
            dataTypeStation.setFitHeight(40);
            hashStation.setFitHeight(40);
            treeStation.setFitHeight(40);
            algorithmStation.setFitHeight(40);
            graphStation.setFitHeight(40);
        }

        {
            Canvas canvas = new Canvas(300, 250);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 1);
            desktop.add(canvas, 7, 4);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 1);
            desktop.add(canvas, 7, 10);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 1);
            desktop.add(canvas, 7, 16);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 2);
            desktop.add(canvas, 1, 10);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 2);
            desktop.add(canvas, 13, 4);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 2);
            desktop.add(canvas, 13, 10);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 3);
            desktop.add(canvas, 13, 16);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 3);
            desktop.add(canvas, 19, 10);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 3);
            desktop.add(canvas, 19, 16);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 3);
            desktop.add(canvas, 13, 22);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 5);
            desktop.add(canvas, 2, 15);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 4);
            desktop.add(canvas, 2, 21);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 5);
            desktop.add(canvas, 8, 15);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 5);
            desktop.add(canvas, 14, 3);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 6);
            desktop.add(canvas, 14, 21);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 6);
            desktop.add(canvas, 20, 21);

            canvas = new Canvas(300, 250);
            gc = canvas.getGraphicsContext2D();
            drawShapes(gc, 5);
            desktop.add(canvas, 20, 3);
        }

    }

    private void drawShapes(GraphicsContext gc, int type) {

        switch(type) {
            case 1:
                gc.setFill(Color.YELLOW);
                gc.setStroke(Color.YELLOW);
                gc.setLineWidth(10);
                gc.strokeLine(20, 15, 20, 235);
                break;

            case 2:
                gc.setFill(Color.GREEN);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(10);
                gc.strokeLine(20, 15, 20, 235);
                break;

            case 3:
                gc.setFill(Color.BLUE);
                gc.setStroke(Color.BLUE);
                gc.setLineWidth(10);
                gc.strokeLine(20, 15, 20, 235);
                break;

            case 4:
                gc.setFill(Color.YELLOW);
                gc.setStroke(Color.YELLOW);
                gc.setLineWidth(10);
                gc.strokeLine(5, 40, 215, 40);
                break;

            case 5:
                gc.setFill(Color.GREEN);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(10);
                gc.strokeLine(5, 40, 215, 40);
                break;

            case 6:
                gc.setFill(Color.BLUE);
                gc.setStroke(Color.BLUE);
                gc.setLineWidth(10);
                gc.strokeLine(5, 40, 215, 40);
                break;

            default:
                System.out.println("");
        }

    }

    @FXML
    void openMPStationPressed(MouseEvent event) {
        System.out.println("OJPSJDF");
        Stage stage = new Stage();
        stage.setTitle("JavaFX Stage Window Title");
        stage.setX(500);
        stage.setY(500);

        stage.setWidth(600);
        stage.setHeight(300);

        stage.showAndWait();
    }



}
