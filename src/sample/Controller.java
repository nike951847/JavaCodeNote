package sample;
//package javafx.scene.web;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.web.HTMLEditor;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.util.*;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class Controller {
    private Parent root;
    boolean railwayLineEnable = false;

    @FXML
    private BorderPane borderPane;
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
    @FXML
    private Button fullScreenButton;
    @FXML
    private Button closeButton;
    @FXML
    private ToolBar desktopToolBar;
    @FXML
    private BorderPane desktopBorderPane;

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

        if(railwayLineEnable) {
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

        //check if the file exist, if not, create them
        {
            String storageLocationDirectory = "C:/Users/Public/Documents/JavaCodeNote";
            File fileDirectory = new File(storageLocationDirectory);
            if(!fileDirectory.exists()) {
                System.out.println("not exist\ncreate directory");
                fileDirectory.mkdirs();
                storageLocationDirectory += "/";
                for(int i=0; i<Main.stationNum; i++) {
                    String tempLocationFile = (storageLocationDirectory + Main.stationName.get(i)+".html");
                    String defaultContet = "<b>Type here to take notes</b>";
                    File fileHTML = new File(tempLocationFile);
                    SaveFile(defaultContet, fileHTML);
                }
            } else {
                System.out.println("exist");
            }
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
    void closeMainTab(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void fullScreenMainTab(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);
    }

    @FXML
    void openMPStationPressed(MouseEvent event) {
<<<<<<< HEAD
        //
        //desktopToolBar.setVisible(false);
        //
=======
>>>>>>> da9e841716c123cacaac402cd1675c50cfd597bf

        HTMLEditor htmlEditor = new HTMLEditor();
        File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/"+Main.stationName.get(0)+".html");
        if(openFile != null){
            String textRead = readFile(openFile);
            htmlEditor.setHtmlText(textRead);
        }

        Stage stage = new Stage();
        ToolBar toolBar = new ToolBar();
        Button buttonReturn = new Button("Return");
        Button buttonExport = new Button("Export");

        buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //save the current file, then return
                File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/"+Main.stationName.get(0)+".html");
                openFile.delete();
                if(openFile != null){
                    String stringHtml = htmlEditor.getHtmlText();
                    SaveFile(stringHtml, openFile);
                }

                toolBar.setVisible(false);
                desktopBorderPane.setTop(desktopToolBar);
                desktopToolBar.setVisible(true);
                borderPane.getChildren().remove(root);
                /*stage.close();
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);*/
            }
        });
        buttonExport.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                String stringHtml = htmlEditor.getHtmlText();
                //htmlText.setText(stringHtml);

                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
                if(file != null){
                    SaveFile(stringHtml, file);
                }
            }
        });

        toolBar.getItems().add(buttonReturn);
<<<<<<< HEAD
        toolBar.getItems().add(buttonSave);
        htmlEditor.setMinWidth(desktop.getWidth());
        root = new VBox(toolBar, htmlEditor);
=======
        toolBar.getItems().add(buttonExport);
        //toolBar.setMinHeight(50);
        //htmlEditor.setMinHeight(200);
        htmlEditor.setMinWidth(desktop.getWidth());
        //root = new VBox(toolBar, htmlEditor);
        root = new VBox(htmlEditor);
        desktopBorderPane.setTop(toolBar);
        toolBar.setVisible(true);


        //Parent root = new HTMLEditor();
>>>>>>> da9e841716c123cacaac402cd1675c50cfd597bf
        Scene scene =algorithmStation.getScene();
        root.translateYProperty().set(scene.getHeight());
        borderPane.getChildren().add(root);
        toolBar.setMinHeight(50);
        toolBar.setMaxWidth(scene.getWidth());
        htmlEditor.setMinHeight(scene.getHeight()-50);
        //htmlEditor.setPrefHeight(scene.getHeight()-50);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            //desktop.getChildren().remove(anchorRoot);
            desktopToolBar.setVisible(false);
        });
        timeline.play();
        /*Scene scene = new Scene(root);
        root.translateYProperty().set(scene.getHeight());
        StackPane parentContainer = (StackPane) ((Node) event.getSource()).getScene().getRoot();

        parentContainer.getChildren().add(root);


        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(parentContainer.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);

        timeline.play();*/
        /*stage.setTitle("Take Notes");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.showAndWait();*/
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        return stringBuffer.toString();
    }

}
