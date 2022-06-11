package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;
import java.util.Vector;

public class Main extends Application {

    static public Vector<Image> imageVector = new Vector<>();
    static public Vector<String> stationName = new Vector<>();
    static final int stationNum = 18;//0~17
    static public Vector<Terminal> allTerminal = new Vector<>();
    static public CentralTerminal centralTerminal = new CentralTerminal();
    static public Vector<Double> skillProficiencyDeTerminal = new Vector<>();

    static public Boolean ifImport = false;
    static public String importPath = "";

    /*
     * 0: OpenMPStation
     * 1: InheritanceStation
     * 2: PolymorphismStation
     * 3: EncapsulationStation
     * 4: MPIStation
     * 5: ClassStation
     *
     * 6: InterfaceStation
     * 7: ExceptionStation
     * 8: ThreadStation
     * 9: CentralStation
     * 10: DFS_BFSStation
     * 11: DistributedStation
     * 12: GPUStation
     * 13: DataTypeStation
     * 14: HashStation
     * 15: TreeStation
     * 16: AlgorithmStation
     * 17: GraphStation
     * */

    //initialize stationName to avoid typo
    static {
        stationName.add("OpenMPStation");//0
        stationName.add("InheritanceStation");//1
        stationName.add("PolymorphismStation");//2
        stationName.add("EncapsulationStation");//3
        stationName.add("MPIStation");//4
        stationName.add("ClassStation");//5.
        stationName.add("InterfaceStation");//6
        stationName.add("ExceptionStation");//7
        stationName.add("ThreadStation");//8
        stationName.add("CentralStation");//9
        stationName.add("DFS_BFSStation");//10
        stationName.add("DistributedStation");//11
        stationName.add("GPUStation");//12
        stationName.add("DataTypeStation");//13
        stationName.add("HashStation");//14
        stationName.add("TreeStation");//15
        stationName.add("AlgorithmStation");//16
        stationName.add("GraphStation");//17
    }

    //initialize imageVector
    static {
        String s = System.getProperty("user.dir");
        for (int i = 0; i < stationNum; i++) {
            if(s.charAt(s.length()-1)=='c'){
                imageVector.add(new Image("file:sample/photo/" + stationName.get(i) + ".png"));//0
            }
            else{
                imageVector.add(new Image("file:src/sample/photo/" + stationName.get(i) + ".png"));//0
            }
            allTerminal.add(new Terminal(stationName.get(i)));
        }
    }


    //initialize proficiency percentage
    static {
        for(int i=0; i<stationNum; i++) {
            skillProficiencyDeTerminal.add(0.0);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startPage.fxml")))));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }
}
