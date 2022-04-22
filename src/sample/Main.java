package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;
import javafx.animation.*;
import javafx.stage.StageStyle;

public class Main extends Application {

    static public Vector<Image> imageVector = new Vector<Image>();
    static public Vector<String> stationName = new Vector<String>();
    static final int stationNum = 18;//0~17

    /*
    * 0: OpenMPStation
    * 1: InheritanceStation
    * 2: PolymorphismStation
    * 3: EncapsulationStation
    * 4: MPIStation
    * 5: ClassStation
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
        stationName.add("ClassStation");//5
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
        for(int i=0; i<stationNum; i++) {
            imageVector.add(new Image("file:src/sample/photo/"+stationName.get(i)+".jpg"));//0
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("EXAMPLE");
        primaryStage.setScene(new Scene(root, 1250, 600));
        primaryStage.setFullScreen(true);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
