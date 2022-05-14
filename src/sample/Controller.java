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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    private Parent root;
    private static final Vector<ImageView> allStationImageView = new Vector<>();
    public static ScrollPane scrollPane;
    @FXML
    private BorderPane borderPane;
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


    public void initialize() {
        //set background image
        Image img = new Image("file:src/sample/photo/" + "DesktopBackground" + ".png");
        desktop.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        //set all station to a vector
        {
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
        {
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
        {
            for (int i = 0; i < Main.stationNum; i++) {
                Main.allTerminal.get(i).setPoint(GridPane.getColumnIndex(allStationImageView.get(i)), GridPane.getRowIndex(allStationImageView.get(i)));
            }
        }

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
            } else {
                //System.out.println("already exist");
            }

        }

        //add mouse event handler to all station
        {
            for (ImageView imageView : allStationImageView) {
                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //System.out.println("["+event.getX()+", "+event.getY()+"]");
                        //System.out.println("["+((ImageView) ((Node) event.getSource())).getX()+", "+((ImageView) ((Node) event.getSource())).getY()+"]");;
                        //((ImageView) ((Node) event.getSource())).getX();
                        //System.out.println(event.getSource().);
                    }
                });
            }
        }

        //set desktopScrollPane drag
        desktopScrollPane.setPannable(true);
        Pane pane = new Pane();

        pane.setPrefSize(2700,1260);
        pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        /*borderPane.getChildren().add(pane);
        pane.toFront();*/
        System.out.println(borderPane.getChildren());

        searchTerminalTextField.setText("Type to search the station");
        scrollPane = desktopScrollPane;

    }

    @FXML
    void searchTerminalTextFieldListener(ActionEvent event) {
        System.out.println(desktop.getHeight()+"　"+desktop.getWidth());
        String target = searchTerminalTextField.getText();
        searchTerminalTextField.clear();

        boolean blFind = false;


        for (String str : Main.stationName) {
            if (target.equals(str)) {
                System.out.println("find station");
                blFind = true;

                centerNodeInScrollPane(desktopScrollPane, allStationImageView.get(Main.stationName.indexOf(target)));
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
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);
    }

    @FXML
    void StationPressed(MouseEvent event) throws IOException {

        int index = allStationImageView.indexOf((ImageView) event.getSource());
        System.out.println(((ImageView) event.getSource()).getId());
        TerminalController.setCurTerminal(Main.allTerminal.get(index));
        System.out.println("curterminal: " + Main.allTerminal.get(index).getName());
        root = FXMLLoader.load(getClass().getResource("terminalpage.fxml"));

        desktopBorderPane.getChildren().add(root);


        root.translateYProperty().set(((Node) (event.getSource())).getScene().getHeight() - desktopToolBar.getHeight());
        //System.out.println(desktopToolBar.getHeight());
        Button terminalPageReturn = new Button();
        terminalPageReturn.setText("Return");
        terminalPageReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                desktopBorderPane.getChildren().remove(root);
                desktopBorderPane.setTop(new VBox(desktopToolBar, searchTerminalTextField));
                searchTerminalTextField.setText("Type to search the station");
            }
        });

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), desktopToolBar.getHeight(), Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            //System.out.println("here");
            desktopBorderPane.setTop(new ToolBar(terminalPageReturn));
        });
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
        String output = "";

        int index = 0;
        Boolean save = false;
        while(index < input.length()) {

            if(index+3 < input.length()) {
               if(input.substring(index, index+4).equals("<br>")) {
                   output += "  \n";
                   index += 4;
                   continue;
               }
            }

            if(index+3 < input.length()) {
                if(input.substring(index, index+4).equals("</p>")) {
                    output += "  \n";
                    index += 4;
                    save = false;
                    continue;
                }
            }

            if(index+3 < input.length()) {
                if(input.substring(index, index+4).equals("<hr>")) {
                    output += "\n```";
                    index += 4;
                    save = false;
                    continue;
                }
            }


            if(input.charAt(index) == '>') {
                if(index-2 >= 0) {
                    if(input.charAt(index-2) == '/') {
                        save = false;
                    } else {
                        save = true;
                    }
                }

                index++;
                continue;
            }

            if(input.charAt(index) == '<') {
                save = false;
            }

            if(save) {
                output += (input.charAt(index));
            }

            index++;
        }

        return output;
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
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(saveContent);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("error in save to MD file");
        }

        stage.close();
    }

}
