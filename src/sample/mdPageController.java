package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


public class mdPageController {

    //vector here

    @FXML
    private VBox blockDisplayVBox;
    @FXML
    private ListView<?> fileList;
    @FXML
    private ScrollPane noteBlockScrollPane;

    @FXML
    public void initialize() {
        fileList.setMinWidth(150);
        Button newBlock = new Button("New Block");
        newBlock.setOnAction(e -> {this.blockDisplayVBox.getChildren().add(new NoteBlock());});
        this.blockDisplayVBox.getChildren().add(new ToolBar(newBlock));
        this.blockDisplayVBox.getChildren().add(new NoteBlock());
        //for(int i=0; i<15; i++) this.blockDisplayVBox.getChildren().add(new NoteBlock());
        //noteBlockScrollPane.resize(blockDisplayVBox.getWidth(),blockDisplayVBox.getHeight());
        //System.out.println(blockDisplayVBox.getHeight());
        //System.out.println(blockDisplayVBox.layoutBoundsProperty().toString());
        //System.out.println(blockDisplayVBox.getPrefWidth());
    }
}
