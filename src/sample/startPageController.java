package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.application.Platform;

import javax.swing.*;


public class startPageController {


    @FXML
    private Button exitButton;
    @FXML
    private Pane pane;
    @FXML
    public void initialize() {
        //System.out.println("start page controller");
        String s = System.getProperty("user.dir");
        Image img;
        if(s.charAt(s.length()-1)=='c'){
            img = new Image("file:sample/photo/" + "start" + ".jpg");
        }
        else{
            img = new Image("file:src/sample/photo/" + "start" + ".jpg");
        }
        System.out.println(img.getHeight());
        pane.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
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

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
            stage.setTitle("EXAMPLE");
            stage.setScene(new Scene(root, 1250, 600));
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setFullScreen(true);
            stage.initStyle(StageStyle.DECORATED);

        } catch(Exception ignored) {}

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
        ((Stage) Objects.requireNonNull(Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null))).close();
    }

}
