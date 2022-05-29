package sample;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.Vector;


import java.awt.event.ItemEvent;

public class NoteBlock extends HBox {

    HBox hBox = new HBox();
    Button deleteButton = new Button("delete");
    ComboBox<String> comboBox = new ComboBox<>();
    //CheckBox checkBox = new CheckBox();
    //TextField textField = new TextField();
    public static Vector<String> optionOfNoteBlock = new Vector<>();

    //set up optionOfNoteBlock
    {
        optionOfNoteBlock.add("Text");
        optionOfNoteBlock.add("Page");
        optionOfNoteBlock.add("To-do list");
        optionOfNoteBlock.add("Heading 1");
        optionOfNoteBlock.add("Heading 2");
        optionOfNoteBlock.add("Heading 3");
        optionOfNoteBlock.add("Table");
        optionOfNoteBlock.add("Bulledted list");
        optionOfNoteBlock.add("Numbered list");
        optionOfNoteBlock.add("Toggle list");
        optionOfNoteBlock.add("Quote");
        optionOfNoteBlock.add("Divider");
        optionOfNoteBlock.add( "Link to page");
        optionOfNoteBlock.add( "Callout");
    }

    {
        this.setSpacing(10);
        this.setHeight(150);
        //comboBox.getItems().addAll("Text", "Page", "To-do list", "Heading 1", "Heading 2", "Heading 3", "Table", "Bulledted list", "Numbered list", "Toggle list", "Quote", "Divider", "Link to page", "Callout");
        for(String str: optionOfNoteBlock) comboBox.getItems().add(str);

        comboBox.setOnAction(e -> {
            switch (comboBox.getValue()) {
                case "Text" -> {
                    this.getChildren().remove(hBox);
                    TextField textField = new TextField();
                    textField.setPrefSize(500,100);
                    textField.setText("input something here");
                    hBox = new HBox(textField);
                    hBox.setSpacing(10);
                    this.getChildren().add(hBox);
                    break;
                }
                case "Page" -> {
                    break;
                }
                case "To-do list" -> {
                    this.getChildren().remove(hBox);
                    TextField textField = new TextField("To-do");
                    textField.setPrefSize(50,20);//should be revised
                    textField.setOnAction(e2 -> {
                        Text textForCount = new Text(textField.getText());
                        textForCount.setFont(textField.getFont());
                        textField.setPrefSize(textForCount.getBoundsInLocal().getWidth()*1.05+15,20);});
                    hBox = new HBox(new CheckBox(),textField);
                    hBox.setSpacing(10);
                    this.getChildren().add(hBox);
                    break;
                }
                case "Heading 1" ,"Heading 2", "Heading 3" -> {
                    this.getChildren().remove(hBox);
                    //setFont(Font.font("Verdana", FontWeight.BOLD, 70));
                    TextField textField = new TextField();
                    switch (comboBox.getValue()) {
                        case "Heading 1" -> {textField.setText("Heading 1"); textField.setFont(Font.font("Verdana", FontWeight.BOLD, 30));}
                        case "Heading 2" -> {textField.setText("Heading 2"); textField.setFont(Font.font("Verdana", FontWeight.BOLD, 25));}
                        case "Heading 3" -> {textField.setText("Heading 3"); textField.setFont(Font.font("Verdana", FontWeight.BOLD, 20));}
                    }
                    textField.setOnAction(e2 -> {
                        Text textForCount = new Text(textField.getText());
                        textForCount.setFont(textField.getFont());
                        textField.setPrefSize(textForCount.getBoundsInLocal().getWidth()*1.05+25,30);});
                    hBox = new HBox(textField);
                    hBox.setSpacing(10);
                    this.getChildren().add(hBox);
                    break;
                }
                default -> {break;}
            }
        });

        deleteButton.setOnAction(e -> {
            this.getChildren().remove(hBox);
            this.getChildren().remove(comboBox);
            this.getChildren().remove(deleteButton);
        });

        this.getChildren().add(deleteButton);
        this.getChildren().add(comboBox);
        this.getChildren().add(hBox);
    }

}