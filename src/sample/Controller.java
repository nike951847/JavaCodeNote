package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private ImageView algorithmStation;

    @FXML
    private ImageView centralStation;

    @FXML
    private ImageView classStation;

    @FXML
    private ImageView dFS_BFSStation;

    @FXML
    private ImageView dataTypeStation;

    @FXML
    private ImageView distributedStation;

    @FXML
    private ImageView encapsulationStation;

    @FXML
    private ImageView exceptionStation;

    @FXML
    private ImageView gPUStation;

    @FXML
    private ImageView graphStation;

    @FXML
    private ImageView hashStation;

    @FXML
    private ImageView inheritanceStation;

    @FXML
    private ImageView interfaceStation;

    @FXML
    private ImageView mPIStation;

    @FXML
    private ImageView openMPStation;

    @FXML
    private ImageView polymorphismStation;

    @FXML
    private ImageView threadStation;

    @FXML
    private ImageView treeStation;

    @FXML
    private GridPane desktop;

    public void initialize() {

        openMPStation.setImage(Main.imageVector.get(0));
        inheritanceStation.setImage(Main.imageVector.get(1));
        polymorphismStation.setImage(Main.imageVector.get(2));
        encapsulationStation.setImage(Main.imageVector.get(3));
        mPIStation.setImage(Main.imageVector.get(4));
        classStation.setImage(Main.imageVector.get(5));
        interfaceStation.setImage(Main.imageVector.get(6));
        exceptionStation.setImage(Main.imageVector.get(7));
        threadStation.setImage(Main.imageVector.get(8));
        centralStation.setImage(Main.imageVector.get(9));
        dFS_BFSStation.setImage(Main.imageVector.get(10));
        distributedStation.setImage(Main.imageVector.get(11));
        gPUStation.setImage(Main.imageVector.get(12));
        dataTypeStation.setImage(Main.imageVector.get(13));
        hashStation.setImage(Main.imageVector.get(14));
        treeStation.setImage(Main.imageVector.get(15));
        algorithmStation.setImage(Main.imageVector.get(16));
        graphStation.setImage(Main.imageVector.get(17));

        openMPStation.setFitHeight(40);
        inheritanceStation.setFitHeight(40);
        polymorphismStation.setFitHeight(40);
        encapsulationStation.setFitHeight(40);
        mPIStation.setFitHeight(40);
        classStation.setFitHeight(40);
        interfaceStation.setFitHeight(40);
        exceptionStation.setFitHeight(40);
        threadStation.setFitHeight(40);
        centralStation.setFitHeight(40);
        dFS_BFSStation.setFitHeight(40);
        distributedStation.setFitHeight(40);
        gPUStation.setFitHeight(40);
        dataTypeStation.setFitHeight(40);
        hashStation.setFitHeight(40);
        treeStation.setFitHeight(40);
        algorithmStation.setFitHeight(40);
        graphStation.setFitHeight(40);

        //desktop.
    }
}
