package sample;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class NoteBlock extends HBox {

    public HBox hBox = new HBox();
    public Button deleteButton = new Button("X");
    public ComboBox<String> comboBox = new ComboBox<>();
    public static Vector<String> optionOfNoteBlock = new Vector<>();
    private int bulletedListRowCount = 0;
    private int numberedListRowCount = 0;
    //set up optionOfNoteBlock
    {
        optionOfNoteBlock.add("Markdown");
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
        optionOfNoteBlock.add("Link to page");
        optionOfNoteBlock.add("Callout");
    }

    {
        this.setSpacing(10);
        this.setHeight(150);
        //comboBox.getItems().addAll("Text", "Page", "To-do list", "Heading 1", "Heading 2", "Heading 3", "Table", "Bulledted list", "Numbered list", "Toggle list", "Quote", "Divider", "Link to page", "Callout");
        for(String str: optionOfNoteBlock) comboBox.getItems().add(str);

        comboBox.setOnAction(e -> {
            this.getChildren().remove(hBox);

            switch (comboBox.getValue()) {
                case "Markdown" -> {
                    TextArea lTextArea = new TextArea("Input Markdown");
                    //TextArea rTextArea = new TextArea("Preview Markdown");
                    TextFlow rTextFlow = new TextFlow();
                    //rTextFlow.setEditable(false);
                    lTextArea.setPrefSize(400,100);
                    rTextFlow.setPrefSize(400,100);
                    hBox = new HBox(lTextArea,rTextFlow);
                    lTextArea.addEventHandler(InputEvent.ANY,(event)->{

                        String[] lines = lTextArea.getText().split("\n");

                        rTextFlow.getChildren().clear();
                        for(String line:lines){
                            line +="\n";
                            Text text = new Text("");
                            if(line.startsWith("#")) {
                                if (line.startsWith("###")) {
                                    text.setText(line.substring(3));
                                    text.setFont(Font.font("",FontWeight.BOLD, 15));

                                } else if (line.startsWith("##")) {
                                    text.setText(line.substring(2));
                                    text.setFont(Font.font("",FontWeight.BOLD, 20));
                                } else {
                                    text.setText(line.substring(1));
                                    text.setFont(Font.font("",FontWeight.BOLD, 30));
                                }

                            }
                            else {
                                text.setText(line);
                            }
                            text.setFill(Color.WHITE);
                            rTextFlow.getChildren().add(text);
                        }
                    });
                    break;

                }

                case "Text" -> {
                    TextArea textArea = new TextArea("input something here");
                    textArea.setPrefSize(500,100);
                    hBox = new HBox(textArea);
                    break;
                }

                case "Page" -> {
                    break;
                }

                case "To-do list" -> {
                    //add an toggle switch here
                    TextField textField = new TextField("To-do");
                    textField.setPrefSize(50,20);//should be revised
                    textField.setOnAction(e2 -> {
                        Text textForCount = new Text(textField.getText());
                        textForCount.setFont(textField.getFont());
                        textField.setPrefSize(textForCount.getBoundsInLocal().getWidth()*1.05+15,20);});
                    hBox = new HBox(new SwitchButton(), textField);
                    break;
                }

                case "Heading 1" ,"Heading 2", "Heading 3" -> {
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
                    break;
                }

                case "Table" -> {
                    TableView tableView = new TableView();
                    tableView.setEditable(true);
                    tableView.getColumns().addAll(new TableColumn<>("A"), new TableColumn<>("B"), new TableColumn<>("C"), new TableColumn<>("D"), new TableColumn<>("E"));

                    hBox = new HBox(tableView);
                    break;
                }

                case "Bulledted list" -> {
                    bulletedListRowCount = 1;
                    ListView listView = new ListView();
                    listView.setEditable(true);
                    listView.setCellFactory(TextFieldListCell.forListView());
                    listView.setFixedCellSize(20);
                    listView.setMaxHeight(listView.getFixedCellSize()*bulletedListRowCount);
                    listView.getItems().addAll("●");
                    listView.setOnKeyPressed(e2 -> {
                        if(e2.getCode().equals(KeyCode.ENTER)) {
                            bulletedListRowCount++;
                            listView.getItems().add("●");
                            listView.setMaxHeight(listView.getFixedCellSize()*bulletedListRowCount);
                        }
                    });
                    hBox = new HBox(listView);
                    break;
                }

                case "Numbered list" -> {
                    numberedListRowCount = 1;
                    ListView listView = new ListView();
                    listView.setEditable(true);
                    listView.setCellFactory(TextFieldListCell.forListView());
                    listView.setFixedCellSize(20);
                    listView.setMaxHeight(listView.getFixedCellSize()*numberedListRowCount);
                    listView.getItems().addAll(String.valueOf(numberedListRowCount));
                    listView.setOnKeyPressed(e2 -> {
                        if(e2.getCode().equals(KeyCode.ENTER)) {
                            numberedListRowCount++;
                            listView.getItems().add(String.valueOf(numberedListRowCount));
                            listView.setMaxHeight(listView.getFixedCellSize()*numberedListRowCount);
                        }
                    });
                    hBox = new HBox(listView);
                    break;
                }

                case "Toggle list" -> {

                    hBox = new HBox();
                    break;
                }

                case "Link to page" -> {
                    TextArea textArea = new TextArea("Input URL");
                    textArea.setEditable(true);
                    textArea.setPrefSize(300,23);
                    textArea.setOnMouseClicked(e2 -> {
                        if(e2.getClickCount()==2) {
                            try {
                                WebView webView = new WebView();
                                WebEngine webEngine = webView.getEngine();
                                webEngine.load(textArea.getText());
                                Stage stage = new Stage();
                                stage.setScene(new Scene(webView, webView.getPrefWidth(), webView.getPrefWidth()-150));
                                stage.show();
                            } catch (Exception exception) {System.out.println("error");}
                        }
                    });
                    hBox = new HBox(textArea);
                    break;
                }

                case "Callout" -> {
                    TextArea textArea = new TextArea();
                    textArea.setText("Type something...");
                    textArea.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

                    Text textForCount = new Text(textArea.getText());
                    textForCount.setFont(textArea.getFont());
                    textArea.setPrefSize(textForCount.getBoundsInLocal().getWidth()*1.05+25, textForCount.getBoundsInLocal().getHeight()*1.05+25);
                    textArea.setOnKeyPressed( e2 -> {
                        textForCount.setText(textArea.getText());
                        textForCount.setFont(textArea.getFont());
                        textArea.setPrefSize(textForCount.getBoundsInLocal().getWidth()*1.05+25, textForCount.getBoundsInLocal().getHeight()*1.05+25);
                    });

                    Label label = new Label( new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x92, (byte)0xA1}, Charset.forName("UTF-8")));
                    label.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
                    hBox = new HBox(label, textArea);
                    break;
                }

                default -> {break;}
            }

            hBox.setSpacing(10);
            this.getChildren().add(hBox);
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
