package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TerminalController {
    public static BorderPane outside;
    @FXML
    private BorderPane mainPane;
    @FXML
    public void initialize() {
        outside = mainPane;
    }

}
