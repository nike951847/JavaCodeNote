package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.FileExport.SaveFIleMarkdown;
import sample.FileExport.SaveFileText;

import java.io.*;
import java.security.SecureRandom;
import java.util.Vector;

public class mdPageController {

    //vector here
    protected static VBox staticBlockDisplayVBox;
    @FXML
    private VBox blockDisplayVBox;
    @FXML
    private ListView<Button> fileList;
    @FXML
    private ImageView imageView;
    private final MenuBar mdPageMenuBar = new MenuBar();
    private static HBox proficiencyHBox;
    private final ProgressBar proficiencyProgressBar;
    private final ProgressIndicator proficiencyProgressIndicator;
    static Terminal curTerminal;

    private final Menu fileMenu;
    private final Menu editMenu;
    private final Menu viewMenu;
    private final Menu helpMenu;
    private final Timeline proficiencyProgressBarTimelineAnimation;
    protected static final Vector<NoteBlock> noteBlocksVector = new Vector<>();
    private final double randomNumber = new SecureRandom().nextDouble();
    public static void save() throws FileNotFoundException {
        System.out.println("save "+noteBlocksVector.size()+"blocks");
        //File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/swp");
        try (
                FileOutputStream fos = new FileOutputStream("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/swp");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            for(NoteBlock noteBlock: noteBlocksVector) {
                if(noteBlock.name.equals("Toggle list")){
                    //noteBlock.context = noteBlock.subn.name+"\n"+noteBlock.subHeading.getText()+"\n"+noteBlock.subn.context;
                    System.out.printf("save %s %n",noteBlock.context);
                }
                System.out.println(noteBlock.context);
                if(noteBlock.needSave)oos.writeObject(noteBlock);
                System.out.println(noteBlock+" "+noteBlock.needSave);
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
            Object o;
            while ((o=ois.readObject())!=null){
                noteBlocksVector.add(new NoteBlock((NoteBlock) o));
                //blockDisplayVBox.getChildren().add(mdPageMenuBar);
                System.out.println(o);
            }
        }
        catch (IOException | ClassNotFoundException e){
            //e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        System.out.println(curTerminal.name+"wwwww");
        fileList.setMinWidth(150);
        staticBlockDisplayVBox = blockDisplayVBox;
        this.blockDisplayVBox.getChildren().add(proficiencyHBox);
        fileMenu.setStyle("-fx-text-fill: #45587a;");
        fileList.setStyle("-fx-base:#2d3c45;-fx-control-inner-background:#2d3c45; -fx-highlight-fill: #2d3c45; -fx-highlight-text-fill: white; -fx-text-fill: white; ");
        for (String s : Main.stationName){
            Button b = new Button(s);
            b.setStyle("-fx-base:#2d3c45;-fx-control-inner-background:#2d3c45; -fx-highlight-fill: #2d3c45; -fx-highlight-text-fill: white; -fx-text-fill: white; ");
            b.setPrefWidth(140);
            b.setOnAction((e)->{
                for(NoteBlock n : noteBlocksVector){
                    System.out.printf("remove to %s %n", n);
                    n.setVisible(false);
                    this.blockDisplayVBox.getChildren().remove(n);
                }
                try {
                    save();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                curTerminal = Main.allTerminal.get(Main.stationName.indexOf(s));

                try {
                    read();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                for(NoteBlock n:noteBlocksVector){
                    System.out.printf("switch to %s %n", n);
                    this.blockDisplayVBox.getChildren().add(n);
                }
            });
            fileList.getItems().add(b);


        }
        editMenu.setStyle("-fx-text-fill: white;");
        viewMenu.setStyle("-fx-text-fill: white;");
        helpMenu.setStyle("-fx-text-fill: white;");
        mdPageMenuBar.setStyle("-fx-base: #3c4759");
        mdPageMenuBar.getMenus().add(fileMenu);
        mdPageMenuBar.getMenus().add(editMenu);
        mdPageMenuBar.getMenus().add(viewMenu);
        mdPageMenuBar.getMenus().add(helpMenu);
        this.blockDisplayVBox.getChildren().add(mdPageMenuBar);
        try {
            read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("init "+noteBlocksVector.size()+"blocks");
        for(NoteBlock n:noteBlocksVector){
            System.out.printf("init %s %n", n);
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
        proficiencyProgressBarTimelineAnimation = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<>() {
            int delayTimeTimelineAnimation = 0;

            @Override
            public void handle(ActionEvent actionEvent) {
                if (delayTimeTimelineAnimation < 120) delayTimeTimelineAnimation++;
                else {
                    if (proficiencyProgressBar.getProgress() < calculateProficiencyPercentage()) {
                        proficiencyProgressBar.setProgress(proficiencyProgressBar.getProgress() + 0.01);
                        proficiencyProgressIndicator.setProgress(proficiencyProgressIndicator.getProgress() + 0.01);
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
                    Thread.sleep(500);
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

        MenuItem markDownMenuItem = new MenuItem("markdown");
        markDownMenuItem.setOnAction(e -> new SaveFIleMarkdown(noteBlocksVector));
        exportMenu.getItems().add(markDownMenuItem);

        MenuItem textMenuItem = new MenuItem("text");
        textMenuItem.setOnAction(e -> new SaveFileText(noteBlocksVector));
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

            if(noteBlock.comboBox != null) {

                String str = noteBlock.comboBox.getValue();
                if(str != null)
                    switch (str) {
                        case "Page" -> {weighted += 6; break;}
                        case "Table", "Bulledted list", "Numbered list", "Toggle list" -> {weighted += 5; break;}
                        case "Markdown", "Code", "Heading 1" -> {weighted += 4; break;}
                        case "Heading 2", "To-do list" -> {weighted += 3; break;}
                        case "Text", "Heading 3" -> {weighted += 2; break;}
                        case "Quote", "Divider", "Link to page", "Callout" -> {weighted += 1; break;}
                        default -> {break;}
                    }
            }

            for(int i=0; i<Main.stationNum; i++) {
                for(int j=0; j<KeyWordAtStation.keyWord[i].size(); j++) {
                    if(noteBlock.toString().contains(KeyWordAtStation.keyWord[i].get(j))) {
                        relatedWords += i*j*(randomNumber);
                    }
                }
            }
        }

        returnValue += (weighted / randomNumber);
        returnValue += relatedWords;

        /*
        while(returnValue < noteBlocksVector.size()*0.03) {
           returnValue /= randomNumber;
           //returnValue += randomNumber*5;
        }*/

        return (returnValue > 1.0)? 1-(1.0/returnValue): (1-returnValue);
    }
    protected static void blockDown(int n){
        System.out.println(n);
        if(n==noteBlocksVector.size()-1) return;

        staticBlockDisplayVBox.getChildren().remove(3,3+noteBlocksVector.size());
        NoteBlock temp = noteBlocksVector.get(n);
        noteBlocksVector.set(n,noteBlocksVector.get(n+1));
        noteBlocksVector.set(n+1,temp);
        for(NoteBlock N:noteBlocksVector){
            staticBlockDisplayVBox.getChildren().add(N);
        }


    }
    protected static void blockUp(int n){
        if(n==0) return;
        staticBlockDisplayVBox.getChildren().remove(3,3+noteBlocksVector.size());
        NoteBlock temp = noteBlocksVector.get(n);
        noteBlocksVector.set(n,noteBlocksVector.get(n-1));
        noteBlocksVector.set(n-1,temp);
        for(NoteBlock N:noteBlocksVector){
            staticBlockDisplayVBox.getChildren().add(N);
        }

    }

}
