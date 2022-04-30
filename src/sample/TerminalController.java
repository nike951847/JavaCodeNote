package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
import javafx.scene.input.KeyEvent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
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
import java.util.stream.Stream;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.Event;
import javafx.stage.FileChooser;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TerminalController {
    private Parent root;
    public static BorderPane outside;
    public static BorderPane static_outside_pane;
    public static Vector<Button> static_button_vec = new Vector<Button>();
    public static Terminal curTerminal = new Terminal();
    public String returnStr = "";
    public Vector<String>[] javaKeyword = new Vector[8];
    //Vector<String>[][] s = new Vector<String>[;
    public Vector<String> javaKeywordColor = new Vector<String>();

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

    //initizlize javaKeyword
    {
        for (int i = 0; i < 8; i++) {
            javaKeyword[i] = new Vector<String>();
        }

        javaKeyword[0].add("private");
        javaKeyword[0].add("protected");
        javaKeyword[0].add("public");

        javaKeyword[1].add("abstract");
        javaKeyword[1].add("class");
        javaKeyword[1].add("extends");
        javaKeyword[1].add("final");
        javaKeyword[1].add("implements");
        javaKeyword[1].add("interface");
        javaKeyword[1].add("native");
        javaKeyword[1].add("new");
        javaKeyword[1].add("static");
        javaKeyword[1].add("strictfp");
        javaKeyword[1].add("synchronized");
        javaKeyword[1].add("transient");
        javaKeyword[1].add("volatile");

        javaKeyword[2].add("break");
        javaKeyword[2].add("case");
        javaKeyword[2].add("continue");
        javaKeyword[2].add("default");
        javaKeyword[2].add("do");
        javaKeyword[2].add("else");
        javaKeyword[2].add("for");
        javaKeyword[2].add("if");
        javaKeyword[2].add("instanceof");
        javaKeyword[2].add("return");
        javaKeyword[2].add("switch");
        javaKeyword[2].add("while");

        javaKeyword[3].add("assert");
        javaKeyword[3].add("catch");
        javaKeyword[3].add("finally");
        javaKeyword[3].add("throw");
        javaKeyword[3].add("throws");
        javaKeyword[3].add("try");

        javaKeyword[4].add("import");
        javaKeyword[4].add("package");

        javaKeyword[5].add("boolean");
        javaKeyword[5].add("byte");
        javaKeyword[5].add("char");
        javaKeyword[5].add("double");
        javaKeyword[5].add("float");
        javaKeyword[5].add("int");
        javaKeyword[5].add("long");
        javaKeyword[5].add("short");
        javaKeyword[5].add("null");

        javaKeyword[6].add("super");
        javaKeyword[6].add("this");
        javaKeyword[6].add("void");

        javaKeyword[7].add("goto");
        javaKeyword[7].add("const");
        //javaKeyword[0].add(new Str);

        javaKeywordColor.add("gray");
        javaKeywordColor.add("silver");
        javaKeywordColor.add("maroon");
        javaKeywordColor.add("red");
        javaKeywordColor.add("purple");
        javaKeywordColor.add("fushsia");
        javaKeywordColor.add("green");
        javaKeywordColor.add("lime");
    }

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
            for (Button button : static_button_vec) {
                button.addEventHandler(ActionEvent.ACTION, noteHandler);
                //button.setText("INIT");
                File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + (button.getId() + ".html"));
                String name = readFile(openFile)[0];
                if (!name.equals("Type here to name the note")) {
                    button.setText(name);
                }

            }
        }
    }

    public void initNote() {
        for (Button button : static_button_vec) {
            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + (button.getId() + ".html"));
            String name = readFile(openFile)[0];
            if (!name.equals("Type here to name the note")) {

                button.setText(name);
            }
        }
    }

    public static void setCurTerminal(Terminal curTerminal) {
        TerminalController.curTerminal = curTerminal;
    }

    class NoteHandler implements EventHandler<Event> {
        @Override
        public void handle(Event event) {
            //System.out.println("My Very Own Private Handler For All Kind Of Events");
            //System.out.println("get terminal name: " + curTerminal.name);
            //System.out.println(((Button) event.getSource()).getId());
            //System.out.println("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");

            HTMLEditor htmlEditor = new HTMLEditor();
            htmlEditor.setPrefHeight(500);
            htmlEditor.setOnKeyPressed(new EventHandler<KeyEvent>() {
                //when pressed update
                @Override
                public void handle(KeyEvent event) {
                    //System.out.println("here");
                    //htmlEditor.setHtmlText(htmlEditor.getHtmlText() + checkKeyword(returnStr));
                    htmlEditor.setHtmlText(updateKeyword(htmlEditor.getHtmlText()));
                    //System.out.println("test:");
                    //System.out.println(htmlEditor.getAccessibleText());
                }
            });

            ToolBar bar = null;
            Node editorToolBarNode = htmlEditor.lookup(".top-toolbar");

            if (editorToolBarNode instanceof ToolBar) {
                bar = (ToolBar) editorToolBarNode;
                //System.out.println("Size before layout pass: " + bar.getItems().size());
            }

            if (bar != null) {
                //System.out.println("Size after layout pass: " + bar.getItems().size());
                Button importButton = new Button();

                importButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Open Image");
                        File importPath = fileChooser.showOpenDialog(new Stage());

                        htmlEditor.setHtmlText(htmlEditor.getHtmlText() + "<img src=\"" + importPath.toString() + "\">");
                        //System.out.println("<img src=\"" + importPath.toString() + "\">");
                        //htmlEditor.setHtmlText(htmlEditor.getHtmlText()+"&lt;img src='file:\\"+importButton.toString()+"' >" );
                    }
                });

                Image importButtonPath = new Image("file:src/sample/photo/" + "CompressedImportButtonLogo.jpg");
                importButton.setGraphic(new ImageView(importButtonPath));
                bar.getItems().add(0, importButton);
                ((Button) bar.getItems().get(0)).setMinWidth(25);
                ((Button) bar.getItems().get(0)).setMaxWidth(25);
                ((Button) bar.getItems().get(0)).setMinHeight(25);
                ((Button) bar.getItems().get(0)).setMaxHeight(25);

                Button addCote = new Button("PG");//PG for programming
                bar.getItems().add(1, addCote);
                addCote.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //System.out.println("here");
                        Stage stage = new Stage();
                        TextField inputCodeArea = new TextField("Enter your code here");
                        Button confirmButton = new Button("Confirm");

                        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                TerminalController.this.returnStr = inputCodeArea.getText();
                                stage.close();
                            }
                        });
                        stage.setScene(new Scene(new VBox(confirmButton, inputCodeArea)));
                        stage.showAndWait();
                        //checkKeyword(returnStr);
                        htmlEditor.setHtmlText(htmlEditor.getHtmlText() + checkKeyword(returnStr));
                    }
                });

            }

            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
            if (openFile != null) {
                String textRead = readFile(openFile)[1];
                htmlEditor.setHtmlText(textRead);
                //System.out.println("the files exists");

                System.out.println(textRead);

                Button buttonReturn = new Button("Return");
                Button buttonExport = new Button("Export");
                ToolBar noteToolBar = new ToolBar(buttonReturn, buttonExport);

                initNote();

                TextField noteName = new TextField("Type here to name the note");
                //System.out.println();
                if (!((Button) event.getSource()).getText().equals("Add New Note")) {
                    noteName.setText(((Button) event.getSource()).getText());
                }

                Scene scene = new Scene(new VBox(noteToolBar, noteName, htmlEditor));
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.setFullScreen(false);
                stage.show();

                buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        //save the current file, then return
                        File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
                        openFile.delete();
                        if (openFile != null) {
                            String stringHtml = htmlEditor.getHtmlText();
                            SaveFile(stringHtml, openFile, noteName.getText() + "<br>\n");
                        }

                        if (!noteName.getText().equals("Type here to name the note"))
                            static_button_vec.get(static_button_vec.indexOf((Button) event.getSource())).setText(noteName.getText());
                        stage.close();
                        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);
                    }
                });

                buttonExport.setOnAction(new EventHandler<ActionEvent>() {
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
                        if (file != null) {
                            SaveFile(stringHtml, file, "<br>\n");
                        }
                    }
                });
            } else {
                //System.out.println("cannot find file");
            }
        }
    }

    private String DeleteBR(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '<') {
                output += input.charAt(i);
            } else {
                break;
            }
        }
        return output;
    }

    private String updateKeyword(String input) {
        String output = "";
        String markTOCode = "```";
        int curMarkIndex = 0;

        //output += "<div class=\"div-1\"> <hr>";

        Vector<Integer> markIndex = new Vector<Integer>();

        if(input.contains(markTOCode)) {
            Pattern p = Pattern.compile(markTOCode);
            Matcher m = p.matcher(input);
            while(m.find()) {
                //System.out.println(m.start());
                markIndex.add(m.start());
            }
        }


        int i = 0;
        while (i < input.length()) {

            if(i==markIndex.get(curMarkIndex)) {

                if(curMarkIndex%2==0) {
                    //System.out.println("here");
                    String temp = "";
                    for(int j=markIndex.get(curMarkIndex)+markTOCode.length(); j<markIndex.get(curMarkIndex+1); j++) {
                        temp += input.charAt(j);
                    }

                    System.out.println(temp);
                    //output += "<b><font color='" + "red" + "'>" + temp + " " + "</font><b/>";
                    output += checkKeyword(temp);
                    i = markIndex.get(curMarkIndex+1)+markTOCode.length();
                    curMarkIndex+=2;
                }
            } else {
                output += input.charAt(i);
            }

            if(curMarkIndex > markIndex.size()-1) break;
            i++;
        }

        //output += "<hr> </div> <style> .div-1 { background-color: #FAFAFA; font-family:Consolas;}</style> <br>";
        //output += "<hr> </div> <style> .div-1 { background-color: #FAFAFA; font-family:Consolas;}</style> <br>";
        //System.out.println(output);
        return output;
    }


    private String checkKeyword(String input) {
        String output = "";
        String[] tokens = input.split(" ");
        //"<div class=\"div-1\"> <hr>" + returnStr + "<hr> </div> <style> .div-1 { background-color: #ABBAEA; font-family:Consolas;}</style> <br>"
        //output += "<div class=\"div-1\"> <hr>";
        //<div style="background-color: #FAFAFA; font-family:Consolas;">hello world</div>
        output += "<div style=\"background-color: #FAFAFA; font-family:Consolas;\">";
        output += "<hr>";
        for (String target : tokens) {
            Boolean used = false;
            for (int i = 0; i < 8; i++) {
                for (String kw : javaKeyword[i]) {
                    if (target.equals(kw)) {
                        //<b><font color='red'>Pratik</font><b/>
                        output += "<b><font color='" + javaKeywordColor.get(i) + "'>" + target + " " + "</font><b/>";
                        used = true;
                    }
                }
            }

            if (!used) {
                //System.out.println(target);
                output += (target + " ");
            }
        }
        //<div style="background-color:aliceblue;padding:25px;">
        //output += "<hr> </div> <style> .div-1 { background-color: #FAFAFA; font-family:Consolas;}</style> <br>";

        output += "<hr>";
        output += "</div><br>";
        System.out.println(output);
        return output;
    }

    private String[] readFile(File file) {
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

        String rt[] = new String[2];
        rt[0] = DeleteBR(noteName);
        rt[1] = stringBuffer.toString();

        return rt;
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
