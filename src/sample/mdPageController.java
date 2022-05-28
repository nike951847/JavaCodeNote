package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class mdPageController {

    //vector here

    @FXML
    private VBox blockDisplayVBox;
    @FXML
    private ListView<?> fileList;
    @FXML
    private ScrollPane noteBlockScrollPane;

    private MenuBar mdPageMenuBar = new MenuBar();
    private HBox proficiencyHBox;
    private ProgressBar proficiencyProgressBar;
    private ProgressIndicator proficiencyProgressIndicator;


    private Menu fileMenu;
    private Menu editMenu;
    private Menu viewMenu;
    private Menu helpMenu;



    @FXML
    public void initialize() {
        fileList.setMinWidth(150);
        Button newBlock = new Button("New Block");
        newBlock.setOnAction(e -> {this.blockDisplayVBox.getChildren().add(new NoteBlock());});
        this.blockDisplayVBox.getChildren().add(proficiencyHBox);


        mdPageMenuBar.getMenus().add(fileMenu);
        mdPageMenuBar.getMenus().add(editMenu);
        mdPageMenuBar.getMenus().add(viewMenu);
        mdPageMenuBar.getMenus().add(helpMenu);
        this.blockDisplayVBox.getChildren().add(mdPageMenuBar);

        this.blockDisplayVBox.getChildren().add(new NoteBlock());
        this.blockDisplayVBox.setSpacing(8);
    }

    //initialize proficiency
    {
        double proficiencyPercentage = 0.7;
        proficiencyProgressBar = new ProgressBar(proficiencyPercentage);
        proficiencyProgressBar.setPrefSize(1000,20);
        proficiencyProgressIndicator = new ProgressIndicator(proficiencyPercentage);
        proficiencyHBox = new HBox(proficiencyProgressBar, proficiencyProgressIndicator);
        proficiencyHBox.setPrefHeight(22);
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
        viewMenu = new Menu("View");
        helpMenu = new Menu("Help");
    }

}
