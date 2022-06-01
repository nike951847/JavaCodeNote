package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.FileExport.SaveFileText;

import java.io.*;
import java.security.SecureRandom;
import java.util.Vector;

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
    private static HBox proficiencyHBox;
    private ProgressBar proficiencyProgressBar;
    private ProgressIndicator proficiencyProgressIndicator;
    static Terminal curTerminal;

    private Menu fileMenu;
    private Menu editMenu;
    private Menu viewMenu;
    private Menu helpMenu;
    private Timeline proficiencyProgressBarTimelineAnimation;
    private static Vector<NoteBlock> noteBlocksVector = new Vector<>();
    public static void save() throws FileNotFoundException {
        System.out.println("save "+noteBlocksVector.size()+"blocks");
        //File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/swp");
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        try (
                FileOutputStream fos = new FileOutputStream("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/swp");
                ObjectOutputStream oos = new ObjectOutputStream(fos);


        ) {
            for(NoteBlock noteBlock: noteBlocksVector) {
                oos.writeObject(noteBlock);
                System.out.println(noteBlock);
            }
            oos.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void read() throws FileNotFoundException {
        noteBlocksVector.clear();
        try (
                FileInputStream fis = new FileInputStream("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/swp");
                ObjectInputStream ois = new ObjectInputStream(fis)

        ) {
            Object o = null;
            while ((o=ois.readObject())!=null){
                noteBlocksVector.add((NoteBlock)o);
                //blockDisplayVBox.getChildren().add(mdPageMenuBar);
                System.out.println(o);
            }
        }
        catch (IOException | ClassNotFoundException e){
            //e.printStackTrace();
        }
    }

    @FXML
    public void initialize() throws FileNotFoundException {
        System.out.println(curTerminal.name+"wwwww");
        fileList.setMinWidth(150);
        this.blockDisplayVBox.getChildren().add(proficiencyHBox);
        fileMenu.setStyle("-fx-text-fill: #45587a;");

        editMenu.setStyle("-fx-text-fill: white;");
        viewMenu.setStyle("-fx-text-fill: white;");
        helpMenu.setStyle("-fx-text-fill: white;");
        mdPageMenuBar.setStyle("-fx-base: #3c4759");
        mdPageMenuBar.getMenus().add(fileMenu);
        mdPageMenuBar.getMenus().add(editMenu);
        mdPageMenuBar.getMenus().add(viewMenu);
        mdPageMenuBar.getMenus().add(helpMenu);
        this.blockDisplayVBox.getChildren().add(mdPageMenuBar);


        NoteBlock noteBlock = new NoteBlock();
        noteBlocksVector.add(noteBlock);

        System.out.println("init "+noteBlocksVector.size()+"blocks");
        for(NoteBlock n:noteBlocksVector){
            System.out.printf("init %s %n", n);
            n.create(n.name);
            this.blockDisplayVBox.getChildren().add(n);
        }
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

        new Thread(() -> {
            while(true) {
                try {
                    double temp = calculateProficiencyPercentage();
                    proficiencyProgressBar.setProgress(temp);
                    proficiencyProgressIndicator.setProgress(temp);
                    System.out.println("value: " + temp);
                    Thread.sleep(300);
                } catch (InterruptedException e) {}
            }
        }).start();
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

        MenuItem textMenuItem = new MenuItem("text");
        textMenuItem.setOnAction(e -> {new SaveFileText(noteBlocksVector);});
        exportMenu.getItems().add(textMenuItem);

        fileMenu.getItems().add(exportMenu);

        editMenu = new Menu("Edit");//insert
        MenuItem insertMenuItem = new MenuItem("Insert Block");
        insertMenuItem.setOnAction(e -> {
            NoteBlock noteBlock = new NoteBlock();
            noteBlocksVector.add(noteBlock);
            System.out.println("has inserted "+noteBlocksVector.size());
            this.blockDisplayVBox.getChildren().add(noteBlock);});
        editMenu.getItems().add(insertMenuItem);

        viewMenu = new Menu("View");
        helpMenu = new Menu("Help");
    }

    private double calculateProficiencyPercentage() {


        double returnValue = 1.0;


        returnValue /= Math.sqrt(noteBlocksVector.size());


        double weighted = 0.0;
        double relatedWords = 0.0;
        for(NoteBlock noteBlock: noteBlocksVector) {
            /*
            switch (noteBlock.comboBox.getValue()) {
                case "Page" -> {weighted += 6; break;}
                case "Table", "Bulledted list", "Numbered list", "Toggle list" -> {weighted += 5; break;}
                case "Markdown", "Code", "Heading 1" -> {weighted += 4; break;}
                case "Heading 2", "To-do list" -> {weighted += 3; break;}
                case "Text", "Heading 3" -> {weighted += 2; break;}
                case "Quote", "Divider", "Link to page", "Callout" -> {weighted += 1; break;}
                default -> {break;}
            }*/

            //System.out.println(noteBlock.comboBox.getValue().toString().length());


            for(int i=0; i<Main.stationNum; i++) {
                for(int j=0; j<KeyWordAtStation.keyWord[i].size(); j++) {
                    if(noteBlock.toString().contains(KeyWordAtStation.keyWord[i].get(j))) {
                        relatedWords += i*j*(new SecureRandom().nextDouble());
                    }
                }
            }
        }
        returnValue += relatedWords;

        //returnValue *= (weighted * new SecureRandom().nextDouble());
        /*
        returnValue += relatedWords;
        while(returnValue < noteBlocksVector.size()*0.03) {
           //returnValue /= new SecureRandom().nextDouble();
            returnValue += new SecureRandom().nextDouble()*5;
        }*/

        return (returnValue > 1.0)? 1.0/returnValue: returnValue/1.0;
        //return noteBlocksVector.size()*0.1;
    }

}
