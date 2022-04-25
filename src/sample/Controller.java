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
import javafx.scene.image.Image;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class Controller {
    private Parent root;
    private static Vector<ImageView> allStationImageView = new Vector<ImageView>();

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
        //set all station to a vector
        {
            allStationImageView.add(openMPStation);//0
            allStationImageView.add(inheritanceStation);
            allStationImageView.add(polymorphismStation);
            allStationImageView.add(encapsulationStation);
            allStationImageView.add(mPIStation);
            allStationImageView.add(classStation);//5
            allStationImageView.add(interfaceStation);
            allStationImageView.add(exceptionStation);
            allStationImageView.add(threadStation);
            allStationImageView.add(centralStation);
            allStationImageView.add(dFS_BFSStation);//10
            allStationImageView.add(distributedStation);
            allStationImageView.add(gPUStation);
            allStationImageView.add(dataTypeStation);
            allStationImageView.add(hashStation);
            allStationImageView.add(treeStation);//15
            allStationImageView.add(algorithmStation);
            allStationImageView.add(graphStation);
        }

        {
            for(int i=0; i<Main.stationNum; i++) {
                allStationImageView.get(i).setImage(Main.imageVector.get(0));
            }
        }

        {
            for(ImageView imageView: allStationImageView) {
                imageView.setFitHeight(40);
            }
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
