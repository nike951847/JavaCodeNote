package sample;
//package javafx.scene.web;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import javax.swing.*;
import java.io.*;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    private Parent root;
    private static final Vector<ImageView> allStationImageView = new Vector<>();
    public static ScrollPane scrollPane;
    public Pane carPane;
    private boolean fullScene = true;
    @FXML
    private Pane pane;
    @FXML
    private TextField searchTerminalTextField;
    @FXML
    private ScrollPane desktopScrollPane;
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
    @FXML
    private Button fullScreenButton;
    @FXML
    private Button closeButton;
    @FXML
    private ToolBar desktopToolBar;
    @FXML
    private BorderPane desktopBorderPane;

    Vector<ImageView> vehicleImages = new Vector<>();

    public void initialize() {
        //set background image
        String s = System.getProperty("user.dir");
        Image img;

        if(Main.ifImport) {
            //need change to white background
            img = new Image("file:sample/photo/" + "WhiteDesktopBackground" + ".png");
        } else if(s.charAt(s.length()-1)=='c'){
            img = new Image("file:sample/photo/" + "DesktopBackground" + ".png");
        }
        else{
            img = new Image("file:src/sample/photo/" + "DesktopBackground" + ".png");
        }
        //set all station to a vector
        if(Main.ifImport) {
            Main.stationName.clear();

            if(Main.importPath != null) {
                System.out.println("import path not null");
                try {

                    for(int i=0; i<5; i++) {

                        String filePathName = "";
                        switch (i) {
                            case 0 -> {filePathName = "redLine.txt";}
                            case 1 -> {filePathName = "blueLine.txt";}
                            case 2 -> {filePathName = "yellowLine.txt";}
                            case 3 -> {filePathName = "orangeLine.txt";}
                            case 4 -> {filePathName = "greenLine.txt";}
                        }

                        InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(Main.importPath + filePathName)));
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String readLine = "";

                        System.out.println("w: " + bufferedReader.readLine());
                        System.out.println("h: " + bufferedReader.readLine());

                        readLine = bufferedReader.readLine();
                        while(readLine != null) {
                            System.out.println(readLine);

                            int index[] = new int[3];
                            int curIndex = 0;
                            for(int j=0; j<readLine.length(); j++) {
                                if(readLine.charAt(j)=='|') {
                                    index[curIndex] = j;
                                    curIndex++;
                                }
                            }

                            if(index[1]==0  || index[2]==0) {
                                System.out.println("index 0 and continue");
                                continue;
                            }

                            int curWidth = Integer.parseInt(readLine.substring(0, index[0]));
                            int curHeight = Integer.parseInt(readLine.substring(index[0]+1, index[1]));
                            String lineColor = readLine.substring(index[1]+1, index[2]);
                            String name = readLine.substring(index[2]+1, readLine.length());

                            String photoColorName = "";
                            //photoColorName = "red.png";

                            switch (i) {
                                case 0 -> {photoColorName = "red.png";}
                                case 1 -> {photoColorName = "blue.png";}
                                case 2 -> {photoColorName = "yellow.png";}
                                case 3 -> {photoColorName = "orange.png";}
                                case 4 -> {photoColorName = "green.png";}
                            }


                            ImageView tempImageView = new ImageView(new Image(Main.importPath + photoColorName));
                            System.out.println("save path: " + Main.importPath + "red.png");
                            tempImageView.setFitHeight(120);
                            tempImageView.setFitWidth(120);
                            tempImageView.setOnMouseClicked(new stationPressedHandler());
                            Label displayName = new Label(name);
                            displayName.setFont(new Font("Arial", 24));
                            displayName.setAlignment(Pos.BOTTOM_CENTER);
                            displayName.setPrefSize(120, 25);
                            desktop.add(new VBox(tempImageView, displayName), curWidth*3, curHeight*3);

                            allStationImageView.add(tempImageView);
                            Main.allTerminal.add(new Terminal(name));
                            Main.stationName.add(name);

                            readLine = bufferedReader.readLine();
                        }

                    }
                    Main.allTerminal.clear();
                    for(String str:Main.stationName){
                        Main.allTerminal.add(new Terminal(str));
                    }
                } catch(Exception e) {}
            } else {
                System.out.println("import path is null");
            }

        } else {
            allStationImageView.add(openMPStation);//0
            allStationImageView.add(inheritanceStation);
            allStationImageView.add(polymorphismStation);
            allStationImageView.add(encapsulationStation);
            allStationImageView.add(mPIStation);
            allStationImageView.add(classStation);//5
            allStationImageView.add(interfaceStation);
            allStationImageView.add(exceptionStation);
            allStationImageView.add(threadStation);
            allStationImageView.add(centralStation);
            allStationImageView.add(dFS_BFSStation);//10
            allStationImageView.add(distributedStation);
            allStationImageView.add(gPUStation);
            allStationImageView.add(dataTypeStation);
            allStationImageView.add(hashStation);
            allStationImageView.add(treeStation);//15
            allStationImageView.add(algorithmStation);
            allStationImageView.add(graphStation);
        }

        if(Main.ifImport) {

        } else {
            for (int i = 0; i < Main.stationNum; i++) {
                allStationImageView.get(i).setImage(Main.imageVector.get(i));
            }

            for (ImageView imageView : allStationImageView) {
                imageView.setFitHeight(90);
            }

            for (int i = 0; i < Main.stationNum; i++) {
                Tooltip.install(allStationImageView.get(i), new Tooltip(Main.stationName.get(i)));
            }
        }

        //set the point(x, y) of all terminal
        if(Main.ifImport) {

        } else {
            for (int i = 0; i < Main.stationNum; i++) {
                Main.allTerminal.get(i).setPoint(GridPane.getColumnIndex(allStationImageView.get(i)), GridPane.getRowIndex(allStationImageView.get(i)));
            }
        }

        //aaa here

        //check if the file exist, if not, create them
        {
            String storageLocationDirectory = "C:/Users/Public/Documents/JavaCodeNote";
            File fileDirectory = new File(storageLocationDirectory);
            if (!fileDirectory.exists()) {
                fileDirectory.mkdirs();
                for (int i = 0; i < Main.stationNum; i++) {
                    File subDirectory = new File(storageLocationDirectory + "/" + Main.stationName.get(i));
                    subDirectory.mkdirs();
                    for (int j = 0; j < 8; j++) {
                        File fileHTML = new File(storageLocationDirectory + "/" + Main.stationName.get(i) + "/note" + j + ".html");
                        SaveFile("<b>Type here to take notes</b>", fileHTML, "Add New Note<br>\n");
                    }
                    //File saveNoteName = new File(storageLocationDirectory + "/" + Main.stationName.get(i) + "/buttonName.txt");
                }
            }  //System.out.println("already exist");


        }

        //add mouse event handler to all station
        {
            for (ImageView imageView : allStationImageView) {
                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                });
            }
        }

        //set desktopScrollPane drag
        desktopScrollPane.setPannable(true);
        carPane = new Pane();

        carPane.setPrefSize(2700,1260);
        carPane.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
        pane.getChildren().add(carPane);
        carPane.toBack();

        System.out.println(pane.getChildren());
        initMRT();
        searchTerminalTextField.setText("Type to search the station");
        scrollPane = desktopScrollPane;

        if(Main.ifImport) {

        } else {
            Building.init(); //?
            for(int i =0;i<27;i++){
                for (int j =0; j<27; j++) {
                    boolean flag = false;
                    for(ImageView imgv :allStationImageView){
                        if(j == GridPane.getColumnIndex(imgv)&&(i-GridPane.getRowIndex(imgv)>=-1&&i-GridPane.getRowIndex(imgv)<=1)) {
                            //System.out.println("station at I:"+i+" J:"+j);
                            flag = true;
                            break;
                        }
                    }
                    for(Pair<Integer,Integer> pair : Building.Road){
                        if(j== pair.getKey()&&i== pair.getValue()){
                            flag = true;
                            break;
                        }
                    }
                    Building.buildingMat[i][j] = new Building(1);
                    ImageView temp = new ImageView(Building.buildingMat[i][j].img);
                    temp.setFitHeight(60);
                    temp.setFitWidth(60);
                    if(!flag) desktop.add(temp,j,i);

                }

            }
        }

    }

    @FXML
    void searchTerminalTextFieldListener(ActionEvent event) {
        System.out.println(desktop.getHeight()+"　"+desktop.getWidth());
        String target = searchTerminalTextField.getText();
        searchTerminalTextField.clear();

        boolean blFind = false;


        for (String str : Main.stationName) {
            if (str.toLowerCase().contains(target.toLowerCase())) {
                System.out.println("find station");
                blFind = true;

                centerNodeInScrollPane(desktopScrollPane, allStationImageView.get(Main.stationName.indexOf(str)));
            }
        }

        if (!blFind) {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(false);
            int rt = JOptionPane.showOptionDialog(null, "Unable to find terminal!", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            if (rt == 0 | rt == -1) {
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);
            }
        }
    }


    @FXML
    void closeMainTab(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void fullScreenMainTab(ActionEvent event) {

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(!fullScene);
        fullScene = !fullScene;
    }

    class stationPressedHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            int index = allStationImageView.indexOf((ImageView) event.getSource());
            System.out.println(((ImageView) event.getSource()).getId());
            TerminalController.setCurTerminal(Main.allTerminal.get(index));
            System.out.println("curterminal: " + Main.allTerminal.get(index).getName());
            mdPageController.curTerminal = Main.allTerminal.get(index);
            //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("terminalpage.fxml")));

            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mdPage.fxml")));
            } catch (Exception e) {}


            desktopBorderPane.getChildren().add(root);


            root.translateYProperty().set(((Node) (event.getSource())).getScene().getHeight() - desktopToolBar.getHeight());
            //System.out.println(desktopToolBar.getHeight());
            Button terminalPageReturn = new Button();
            terminalPageReturn.setText("Return");
            terminalPageReturn.setOnAction(actionEvent -> {
                try {
                    mdPageController.save();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                desktopBorderPane.getChildren().remove(root);
                desktopBorderPane.setTop(new VBox(desktopToolBar, searchTerminalTextField));
                searchTerminalTextField.setText("Type to search the station");
            });

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(), desktopToolBar.getHeight(), Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(t -> {
                //System.out.println("here");
                desktopBorderPane.setTop(new ToolBar(terminalPageReturn));
            });
            try {
                mdPageController.read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            timeline.play();
        }
    }
    @FXML
    void StationPressed(MouseEvent event) throws IOException {
        int index = allStationImageView.indexOf((ImageView) event.getSource());
        System.out.println(((ImageView) event.getSource()).getId());
        TerminalController.setCurTerminal(Main.allTerminal.get(index));
        System.out.println("curterminal: " + Main.allTerminal.get(index).getName());
        mdPageController.curTerminal = Main.allTerminal.get(index);
                //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("terminalpage.fxml")));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mdPage.fxml")));

        desktopBorderPane.getChildren().add(root);


        root.translateYProperty().set(((Node) (event.getSource())).getScene().getHeight() - desktopToolBar.getHeight());
        //System.out.println(desktopToolBar.getHeight());
        Button terminalPageReturn = new Button();
        terminalPageReturn.setText("Return");
        terminalPageReturn.setOnAction(actionEvent -> {
            try {
                mdPageController.save();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            desktopBorderPane.getChildren().remove(root);
            desktopBorderPane.setTop(new VBox(desktopToolBar, searchTerminalTextField));
            searchTerminalTextField.setText("Type to search the station");
        });

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), desktopToolBar.getHeight(), Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            //System.out.println("here");
            desktopBorderPane.setTop(new ToolBar(terminalPageReturn));
        });
        try {
            mdPageController.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        timeline.play();


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

        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        String[] rt = new String[2];
        rt[0] = noteName;
        rt[1] = stringBuffer.toString();

        return rt;
    }

    private void centerNodeInScrollPane(ScrollPane scrollPane, Node node) {

        double h1 = scrollPane.getContent().getBoundsInLocal().getHeight();
        double y = (node.getBoundsInParent().getMaxY() + node.getBoundsInParent().getMinY()) / 2.0;
        double v1 = scrollPane.getViewportBounds().getHeight();


        double h2 = scrollPane.getContent().getBoundsInLocal().getWidth();
        double x = (node.getBoundsInParent().getMaxX() + node.getBoundsInParent().getMinX()) / 2.0;
        double v2 = scrollPane.getViewportBounds().getWidth();

        scrollPane.setVvalue(scrollPane.getVmax() * ((y - 0.5 * v1) / (h1 - v1)));
        scrollPane.setHvalue(scrollPane.getHmax() * ((x - 0.5 * v2) / (h2 - v2)));
    }

    static public String hTMLtoMDConverter(String input) {
        StringBuilder output = new StringBuilder();

        int index = 0;
        boolean save = false;
        boolean addJavaOrNot = true;
        while(index < input.length()) {

            if(index+3 < input.length()) {
               if(input.startsWith("<br>", index)) {
                   output.append("  \n");
                   index += 4;
                   continue;
               }
            }

            if(index+3 < input.length()) {
                if(input.startsWith("</p>", index)) {
                    output.append("  \n");
                    index += 4;
                    save = false;
                    continue;
                }
            }

            if(index+3 < input.length()) {
                if(input.startsWith("<hr>", index)) {
                    output.append("\n```");

                    if(addJavaOrNot) {
                        output.append("java");
                        addJavaOrNot = false;
                    } else {
                        addJavaOrNot = true;
                    }

                    index += 4;
                    save = false;
                    continue;
                }
            }


            if(input.charAt(index) == '>') {
                if(index-2 >= 0) {
                    save = input.charAt(index - 2) != '/';
                }

                index++;
                continue;
            }

            if(input.charAt(index) == '<') {
                save = false;
            }

            if(save) {
                output.append(input.charAt(index));
            }

            index++;
        }

        return output.toString();
    }

    static public void saveMD(String saveContent) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MD files (*.md)", "*.md");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        Stage stage = new Stage();
        File file = fileChooser.showSaveDialog(stage);

        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(saveContent);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("error in save to MD file");
        }

        stage.close();
    }
    void initMRT(){

        Vehicle.init();
        for(Vehicle vehicle: Vehicle.vehicles){
            vehicleImages.add(vehicle.imageView);
            vehicle.imageView.setVisible(true);
            vehicle.pathTransition.play();
            System.out.println(vehicle.imageView.getFitHeight());

        }
        for(ImageView imageView: vehicleImages){
            carPane.getChildren().add(imageView);
        }

    }

    @FXML
    void returnToStartPage(ActionEvent event) {

        try {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startPage.fxml")))));
        } catch (Exception e) {}

    }

}

