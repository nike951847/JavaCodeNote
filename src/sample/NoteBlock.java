package sample;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Vector;

public class NoteBlock extends HBox implements Serializable {
    static Vector<Color> colors = new Vector<>();
    static Vector<String>[]  javaKeyword = (Vector<String>[]) new Vector[8];

    public transient HBox hBox = new HBox();
    public transient Button deleteButton = new Button("X");
    public transient ComboBox<String> comboBox = new ComboBox<>();
    public static Vector<String> optionOfNoteBlock = new Vector<>();
    protected String name ="";
    protected String context;

    private int bulletedListRowCount = 0;
    private int numberedListRowCount = 0;
    //set up optionOfNoteBlock
    {
        for (int i = 0; i < 8; i++) {
            javaKeyword[i] = new Vector<>();
        }

        javaKeyword[0].add("private");
        javaKeyword[0].add("protected");
        javaKeyword[0].add("public");

        javaKeyword[1].add("abstract");
        javaKeyword[1].add("class");
        javaKeyword[1].add("extends");
        javaKeyword[1].add("final");
        javaKeyword[1].add("implements");
        javaKeyword[1].add("interface");
        javaKeyword[1].add("native");
        javaKeyword[1].add("new");
        javaKeyword[1].add("static");
        javaKeyword[1].add("strictfp");
        javaKeyword[1].add("synchronized");
        javaKeyword[1].add("transient");
        javaKeyword[1].add("volatile");

        javaKeyword[2].add("break");
        javaKeyword[2].add("case");
        javaKeyword[2].add("continue");
        javaKeyword[2].add("default");
        javaKeyword[2].add("do");
        javaKeyword[2].add("else");
        javaKeyword[2].add("for");
        javaKeyword[2].add("if");
        javaKeyword[2].add("instanceof");
        javaKeyword[2].add("return");
        javaKeyword[2].add("switch");
        javaKeyword[2].add("while");

        javaKeyword[3].add("assert");
        javaKeyword[3].add("catch");
        javaKeyword[3].add("finally");
        javaKeyword[3].add("throw");
        javaKeyword[3].add("throws");
        javaKeyword[3].add("try");

        javaKeyword[4].add("import");
        javaKeyword[4].add("package");

        javaKeyword[5].add("boolean");
        javaKeyword[5].add("byte");
        javaKeyword[5].add("char");
        javaKeyword[5].add("double");
        javaKeyword[5].add("float");
        javaKeyword[5].add("int");
        javaKeyword[5].add("long");
        javaKeyword[5].add("short");
        javaKeyword[5].add("null");

        javaKeyword[6].add("super");
        javaKeyword[6].add("this");
        javaKeyword[6].add("void");

        javaKeyword[7].add("goto");
        javaKeyword[7].add("const");
        //javaKeyword[0].add(new Str);
    }
    {
        colors.add(Color.rgb(107, 184, 219));
        colors.add(Color.rgb(107, 219, 210));
        colors.add(Color.rgb(108, 184, 142));
        colors.add(Color.rgb(123, 165, 237));
        colors.add(Color.rgb(164, 140, 209));
        colors.add(Color.rgb(194, 177, 227));
        colors.add(Color.rgb(71, 200, 230));
        colors.add(Color.rgb(189, 242, 208));
        colors.add(Color.rgb(165, 237, 126));
        optionOfNoteBlock.add("Markdown");
        optionOfNoteBlock.add("Text");
        optionOfNoteBlock.add("Page");
        optionOfNoteBlock.add("Code");
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
            if(name.equals(comboBox.getValue())) return;
            create(comboBox.getValue());

        });

        /*deleteButton.setOnAction(e -> {
            this.getChildren().remove(hBox);
            this.getChildren().remove(comboBox);
            this.getChildren().remove(deleteButton);
        });*/

        this.getChildren().add(deleteButton);
        this.getChildren().add(comboBox);
        this.getChildren().add(hBox);
    }


    public String toString() {
        return "NoteBlock{" +
                "Name:" +name+
                ", hBox=" + hBox +
                ", deleteButton=" + deleteButton +
                ", comboBox=" + comboBox +
                ", bulletedListRowCount=" + bulletedListRowCount +
                ", numberedListRowCount=" + numberedListRowCount +
                '}';
    }
    protected void create(String type){
        if(deleteButton==null) {
            deleteButton = new Button("X");
            this.getChildren().add(deleteButton);
            deleteButton.setOnAction(e -> {
                this.getChildren().remove(hBox);
                this.getChildren().remove(comboBox);
                this.getChildren().remove(deleteButton);
            });
        }
        if(comboBox==null) {
            comboBox = new ComboBox<>();
            this.getChildren().add(comboBox);
            comboBox.setOnAction(e -> {
                if(name.equals(comboBox.getValue())) return;
                create(comboBox.getValue());

            });
        }



        /*deleteButton.setOnAction(e -> {
            this.getChildren().remove(hBox);
            this.getChildren().remove(comboBox);
            this.getChildren().remove(deleteButton);
        });*/
        for(String str: optionOfNoteBlock) comboBox.getItems().add(str);
        this.getChildren().remove(hBox);
        name = type;
        switch (type) {
            case "Markdown" -> {
                TextArea lTextArea;
                if(!name.equals("")){
                    lTextArea = new TextArea(context);
                }
                else{
                    lTextArea = new TextArea("Input Markdown");
                }
                lTextArea.setStyle("-fx-base:#2d3c45;-fx-control-inner-background:#2d3c45; -fx-highlight-fill: #2d3c45; -fx-highlight-text-fill: white; -fx-text-fill: white; ");
                //TextArea rTextArea = new TextArea("Preview Markdown");
                TextFlow rTextFlow = new TextFlow();
                //rTextFlow.setEditable(false);
                lTextArea.setPrefSize(400,100);
                rTextFlow.setPrefSize(400,100);
                hBox = new HBox(lTextArea,rTextFlow);
                lTextArea.addEventHandler(InputEvent.ANY,(event)->{
                    if(lTextArea.getText() != null) {context = lTextArea.getText();
                    String[] lines = lTextArea.getText().split("\n");

                    rTextFlow.getChildren().clear();
                    for(String line:lines) {
                        line += "\n";
                        Text text = new Text("");
                        if (line.startsWith("#")) {
                            if (line.startsWith("###")) {
                                text.setText(line.substring(3));
                                text.setFont(Font.font("", FontWeight.BOLD, 15));

                            } else if (line.startsWith("##")) {
                                text.setText(line.substring(2));
                                text.setFont(Font.font("", FontWeight.BOLD, 20));
                            } else {
                                text.setText(line.substring(1));
                                text.setFont(Font.font("", FontWeight.BOLD, 30));
                            }

                        } else {
                            text.setText(line);
                        }
                        text.setFill(Color.WHITE);
                        rTextFlow.getChildren().add(text);
                    }
                    }
                });
                break;

            }
            case "Code" -> {
                TextArea lTextArea;
                if(!name.equals("")){

                     lTextArea = new TextArea(context);
                }
                else{
                     lTextArea = new TextArea("Input Code");
                }

                lTextArea.setStyle("-fx-base:#2d3c45;-fx-control-inner-background:#2d3c45; -fx-highlight-fill: #2d3c45; -fx-highlight-text-fill: white; -fx-text-fill: white; ");

                TextFlow rTextFlow = new TextFlow();
                lTextArea.setPrefSize(400,100);
                rTextFlow.setPrefSize(400,100);
                hBox = new HBox(lTextArea,rTextFlow);
                lTextArea.addEventHandler(InputEvent.ANY,(event)->{
                    if(lTextArea.getText()==null)return;
                    context = lTextArea.getText();

                    rTextFlow.getChildren().clear();
                    boolean oneLineCommit = false;
                    boolean multLineCommit = false;

                    for(String line:lTextArea.getText().split("\n")){

                        if(line.startsWith("//")){
                            Text text = new Text("");
                            text.setText(line);
                            text.setFill(Color.rgb(94,94,94));
                        }
                        else{
                            for(String word: line.split(" ")) {
                                Text text = new Text("");

                                text.setText(word + " ");
                                if (word.startsWith("//")){
                                    oneLineCommit = true;
                                }
                                if(word.startsWith("/*")){
                                    multLineCommit = true;
                                }
                                if(word.contains("*/")){
                                    text.setFill(Color.rgb(94,94,94));
                                    multLineCommit = false;
                                }

                                text.setFill(Color.WHITE);
                                if(multLineCommit||oneLineCommit){
                                    text.setFill(Color.rgb(94,94,94));
                                    rTextFlow.getChildren().add(text);
                                    continue;
                                }
                                for (int i = 0; i < 8; i++) {
                                    for (String keyword : javaKeyword[i]) {
                                        if (word.equals(keyword)) {
                                            text.setFill(colors.get(i));
                                            break;
                                        }
                                    }
                                }
                                rTextFlow.getChildren().add(text);
                            }



                        }
                        rTextFlow.getChildren().add(new Text("\n"));
                        oneLineCommit = false;

                    }
                });
                break;
            }
            case "Text" -> {
                TextArea textArea;
                if(!name.equals("")){

                    textArea = new TextArea(context);
                }
                else{
                    textArea = new TextArea("Input Code");
                }
                textArea.setStyle("-fx-base:#2d3c45;-fx-control-inner-background:#2d3c45; -fx-highlight-fill: #2d3c45; -fx-highlight-text-fill: white; -fx-text-fill: white; ");
                textArea.setPrefSize(500,100);
                textArea.addEventHandler(InputEvent.ANY,(event)->{
                    context = textArea.getText();
                });
                hBox = new HBox(textArea);
            }

            case "Page" -> {
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
                textField.setStyle("-fx-base:#1e2433;-fx-control-inner-background:#1e2433; -fx-highlight-fill: #1e2433; -fx-highlight-text-fill: white; -fx-text-fill: white; ");

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

        if(hBox!=null)hBox.setSpacing(10);
        if(hBox!=null)this.getChildren().add(hBox);
    }
}
