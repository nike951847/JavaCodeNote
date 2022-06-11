package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.input.KeyCombination;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import javafx.stage.StageStyle;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.application.Platform;

import javax.swing.*;


public class startPageController {


    @FXML
    private Button exitButton;

    public void initialize() {
        //System.out.println("start page controller");
    }

    @FXML
    void importButton(ActionEvent event) {

        Main.ifImport = true;

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.showOpenDialog(null);

        //System.out.println(jFileChooser.getSelectedFile() + "\\");
        Main.importPath = jFileChooser.getSelectedFile() + "\\";
        System.out.println(Main.importPath);

        /*
        if(Main.importPath != null) {
            try {

                String [] fileName = new String[5];
                fileName[0] = "redLine.txt";
                fileName[1] = "blueLine.txt";
                fileName[2] = "yellowLine.txt";
                fileName[3] = "orangeLine.txt";
                fileName[4] = "greenLine.txt";

                for(int i=0; i<5; i++) {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(Main.importPath + fileName[i])));
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String readLine = bufferedReader.readLine();
                    while(readLine != null) {
                        System.out.println(readLine);
                        readLine = bufferedReader.readLine();
                    }
                    System.out.println("------------");
                }

            } catch(Exception e) {}
        }*/

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
            stage.setTitle("EXAMPLE");
            stage.setScene(new Scene(root, 1250, 600));
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setFullScreen(true);
            stage.initStyle(StageStyle.DECORATED);

        } catch(Exception e) {}

    }

    @FXML
    void newPage(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
            stage.setTitle("EXAMPLE");
            stage.setScene(new Scene(root, 1250, 600));
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setFullScreen(true);
            stage.initStyle(StageStyle.DECORATED);

        } catch(Exception e) {}

    }

    @FXML
    void exitPage(ActionEvent event) {
        ((Stage)Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null)).close();
    }

}
