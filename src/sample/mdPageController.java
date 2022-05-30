package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.sql.Time;


public class mdPageController {

    //vector here

    @FXML
    private VBox blockDisplayVBox;
    @FXML
    private ListView<?> fileList;
    @FXML
    private ScrollPane noteBlockScrollPane;
    @FXML
    private ImageView imageView;
    private MenuBar mdPageMenuBar = new MenuBar();
    private HBox proficiencyHBox;
    private ProgressBar proficiencyProgressBar;
    private ProgressIndicator proficiencyProgressIndicator;


    private Menu fileMenu;
    private Menu editMenu;
    private Menu viewMenu;
    private Menu helpMenu;
    private Timeline proficiencyProgressBarTimelineAnimation;


    @FXML
    public void initialize() {
        fileList.setMinWidth(150);
        this.blockDisplayVBox.getChildren().add(proficiencyHBox);
        fileMenu.setStyle("-fx-text-fill: #45587a;");
        fileMenu.ge
        editMenu.setStyle("-fx-text-fill: white;");
        viewMenu.setStyle("-fx-text-fill: white;");
        helpMenu.setStyle("-fx-text-fill: white;");

        mdPageMenuBar.getMenus().add(fileMenu);
        mdPageMenuBar.getMenus().add(editMenu);
        mdPageMenuBar.getMenus().add(viewMenu);
        mdPageMenuBar.getMenus().add(helpMenu);
        mdPageMenuBar.setStyle("-fx-background-color:  #45587a;");
        this.blockDisplayVBox.getChildren().add(mdPageMenuBar);

        this.blockDisplayVBox.getChildren().add(new NoteBlock());
        this.blockDisplayVBox.setSpacing(8);

        proficiencyProgressBarTimelineAnimation.play();
        String s = System.getProperty("user.dir");
        Image img;
        if(s.charAt(s.length()-1)=='c'){
            img = new Image("file:sample/photo/cover/" + "temp" + ".jpg");
        }
        else{
            img = new Image("file:src/sample/photo/cover/" + "temp" + ".jpg");
        }
        imageView.setImage(img);
        System.out.println(imageView.getFitHeight());
    }

    //initialize proficiency
    {
        proficiencyProgressBar = new ProgressBar(0);
        proficiencyProgressBar.setPrefSize(1000,20);
        proficiencyProgressIndicator = new ProgressIndicator(0);
        proficiencyHBox = new HBox(proficiencyProgressBar, proficiencyProgressIndicator);
        proficiencyHBox.setPrefHeight(22);
        proficiencyProgressBarTimelineAnimation = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            int delayTimeTimelineAnimation = 0;
            @Override
            public void handle(ActionEvent actionEvent) {
                if(delayTimeTimelineAnimation < 120) delayTimeTimelineAnimation++;
                else {
                    if(proficiencyProgressBar.getProgress() < calculateProficiencyPercentage()) {
                        proficiencyProgressBar.setProgress(proficiencyProgressBar.getProgress()+0.01);
                        proficiencyProgressIndicator.setProgress(proficiencyProgressIndicator.getProgress()+0.01);
                    }
                }
            }
        }));
        proficiencyProgressBarTimelineAnimation.setCycleCount(Timeline.INDEFINITE);
    }

    //set up menu
    {
        fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        fileMenu.getItems().add(newMenuItem);

        MenuItem saveMenuItem = new MenuItem("Save");
        fileMenu.getItems().add(saveMenuItem);

        MenuItem saveAsMenuItem = new MenuItem("Save As");
        fileMenu.getItems().add(saveAsMenuItem);

        Menu exportMenu = new Menu("Export");
        exportMenu.getItems().add(new MenuItem("docx"));
        exportMenu.getItems().add(new MenuItem("html"));
        exportMenu.getItems().add(new MenuItem("pdf"));
        exportMenu.getItems().add(new MenuItem("markdown"));
        exportMenu.getItems().add(new MenuItem("text"));
        fileMenu.getItems().add(exportMenu);

        editMenu = new Menu("Edit");//insert
        MenuItem insertMenuItem = new MenuItem("Insert Block");
        insertMenuItem.setOnAction(e -> {this.blockDisplayVBox.getChildren().add(new NoteBlock());});
        editMenu.getItems().add(insertMenuItem);

        viewMenu = new Menu("View");
        helpMenu = new Menu("Help");
    }

    private double calculateProficiencyPercentage() {
        return 0.7;
    }

}
