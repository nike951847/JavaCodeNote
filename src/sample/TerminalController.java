package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Vector;
import java.io.File;
import java.io.BufferedReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.web.HTMLEditor;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.Event;
import javafx.stage.FileChooser;
import javafx.scene.input.KeyCombination;

public class TerminalController {
    private Parent root;
    public static BorderPane outside;
    public static BorderPane static_outside_pane;
    public static Vector<Button> static_button_vec = new Vector<>();
    public static Terminal curTerminal = new Terminal();

    public static String curFolder = "";
    @FXML
    private BorderPane mainPane;
    @FXML
    private BorderPane outsidePane;

    @FXML
    private Button note0;
    @FXML
    private Button note1;
    @FXML
    private Button note2;
    @FXML
    private Button note3;
    @FXML
    private Button note4;
    @FXML
    private Button note5;
    @FXML
    private Button note6;
    @FXML
    private Button note7;

    @FXML
    public void initialize() {
        {
            outside = mainPane;
            static_outside_pane = outsidePane;
            static_button_vec.add(note0);
            static_button_vec.add(note1);
            static_button_vec.add(note2);
            static_button_vec.add(note3);
            static_button_vec.add(note4);
            static_button_vec.add(note5);
            static_button_vec.add(note6);
            static_button_vec.add(note7);
        }
        {
            NoteHandler noteHandler = new NoteHandler();
            for(Button button: static_button_vec) {
                button.addEventHandler(ActionEvent.ACTION, noteHandler);
                //button.setText("INIT");
                File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + (button.getId() + ".html"));
                String name = readFile(openFile)[0];
                if(!name.equals("Type here to name the note")) {
                    button.setText(name);
                }
            }
        }
    }

    //no use?
    public void initNote() {
        System.out.println("name" + curTerminal.name);
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " " + curTerminal.noteName[i]);
            if (curTerminal.noteName[i] == null)
                static_button_vec.get(i).setText("INIT");
            else static_button_vec.get(i).setText(curTerminal.noteName[i]);
        }
    }

    public static void setCurTerminal(Terminal curTerminal) {
        TerminalController.curTerminal = curTerminal;
    }

    private String [] readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        String noteName = "";

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            noteName = bufferedReader.readLine();
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

        String rt [] = new String[2];
        rt[0] = noteName;
        rt[1] = stringBuffer.toString();

        return rt;
    }

    class NoteHandler implements EventHandler<Event> {
        @Override
        public void handle(Event event) {
            //System.out.println("My Very Own Private Handler For All Kind Of Events");
            System.out.println(curTerminal.name);
            System.out.println(((Button)event.getSource()).getId());
            System.out.println("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");

            HTMLEditor htmlEditor = new HTMLEditor();
            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
            if(openFile != null){
                String textRead = readFile(openFile)[1];
                htmlEditor.setHtmlText(textRead);
                System.out.println("the files exists");

                Button buttonReturn = new Button("Return");
                Button buttonExport = new Button("Export");
                ToolBar noteToolBar = new ToolBar(buttonReturn, buttonExport);

                TextField noteName = new TextField("Type here to name the note");
                if(!((Button) event.getSource()).getText().equals("Add New Note")) {
                    noteName.setText(((Button) event.getSource()).getText());
                }

                Scene scene = new Scene(new VBox(noteToolBar, noteName, htmlEditor));
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.setFullScreen(true);
                stage.show();

                buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        //save the current file, then return
                        File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
                        openFile.delete();
                        if(openFile != null){
                            String stringHtml = htmlEditor.getHtmlText();
                            if(!noteName.getText().equals("Type here to name the note"))
                                SaveFile(stringHtml, openFile, "Add New Note<br>\n");
                            else
                                SaveFile(stringHtml, openFile, noteName.getText() + "<br>\n");
                        }

                        if(!noteName.getText().equals("Type here to name the note"))
                            static_button_vec.get(static_button_vec.indexOf((Button) event.getSource())).setText(noteName.getText());
                        //toolBar.setVisible(false);
                        //desktopBorderPane.setTop(desktopToolBar);
                        //desktopToolBar.setVisible(true);
                        //TerminalController.outside.getChildren().remove(root);
                        stage.close();
                        //((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
                        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);

                        System.out.println("here");
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
                            SaveFile(stringHtml, file, "<br>\n");
                        }
                    }
                });



                /*
                root = new VBox(htmlEditor);
                outsidePane.getChildren().add(root);
                root.translateYProperty().set(((Node)(event.getSource())).getScene().getHeight());
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                timeline.getKeyFrames().add(kf);
                timeline.setOnFinished(t -> {
                    //desktop.getChildren().remove(anchorRoot);
                    //desktopToolBar.setVisible(false);
                });
                timeline.play();*/
            } else {
                System.out.println("cannot find file");
            }
        }

        private void SaveFile(String content, File file, String buttonName) {
            try {
                FileWriter fileWriter = null;

                fileWriter = new FileWriter(file);
                fileWriter.write(buttonName + "\n" + content);
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
