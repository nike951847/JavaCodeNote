package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.util.Vector;

public class TerminalController {
    public static BorderPane outside;
    public static BorderPane static_outside_pane;
    public static Vector<Button> static_button_vec =new Vector<>();
    public static Terminal curTerminal = new Terminal();
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

    public static void setCurTerminal(){


    }
    @FXML
    public void initialize() {
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
    public static void initNote(){
        System.out.println("name" + curTerminal.name);
        for(int i =0;i<8;i++) {
            System.out.println(i+" "+curTerminal.noteName[i]);
            if(curTerminal.noteName[i]==null)
                static_button_vec.get(i).setText("Add New Note");
            else static_button_vec.get(i).setText(curTerminal.noteName[i]);
        }
    }

    public static void setCurTerminal(Terminal curTerminal) {
        TerminalController.curTerminal = curTerminal;
    }
}
