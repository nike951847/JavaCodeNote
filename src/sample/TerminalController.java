package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.SecureRandom;

public class TerminalController {
    public static BorderPane outside;
    public static BorderPane static_outside_pane;
    public static Vector<Button> static_button_vec = new Vector<Button>();
    public static Terminal curTerminal = new Terminal();
    @SuppressWarnings("unchecked")
    Vector<String>[]  javaKeyword = (Vector<String>[]) new Vector[8];
    public static Vector<String> javaKeywordColor = new Vector<>();

    public CategoryAxis terminalBarChartXAxis = new CategoryAxis();
    public NumberAxis terminalBarChartYAxis = new NumberAxis();
    public BarChart<String, Number> terminalBarChart = new BarChart<>(terminalBarChartXAxis, terminalBarChartYAxis);
    static public String [] capabilityType = new String[] {"綜合熟練程度", "開發品質", "創意思考能力", "數據分析能力"};
    private int countKeyword = 0;


    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane baseAnchorPane;
    @FXML
    private BorderPane outsidePane;
    @FXML
    private Button note0;
    @FXML
    private Button note1;
    @FXML
    private Button note2;
    @FXML
    private Button note3;
    @FXML
    private Button note4;
    @FXML
    private Button note5;
    @FXML
    private Button note6;
    @FXML
    private Button note7;


    //initizlize javaKeyword
    {
        for (int i = 0; i < 8; i++) {
            javaKeyword[i] = new Vector<>();
        }

        javaKeyword[0].add("private");
        javaKeyword[0].add("protected");
        javaKeyword[0].add("public");

        javaKeyword[1].add("abstract");
        //javaKeyword[1].add("class");
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
        javaKeyword[5].add("String");
        javaKeyword[5].add("null");

        javaKeyword[6].add("super");
        javaKeyword[6].add("this");
        javaKeyword[6].add("void");

        javaKeyword[7].add("goto");
        javaKeyword[7].add("const");
        //javaKeyword[0].add(new Str);

        javaKeywordColor.add("gray");
        javaKeywordColor.add("silver");
        javaKeywordColor.add("maroon");
        javaKeywordColor.add("red");
        javaKeywordColor.add("purple");
        javaKeywordColor.add("fushsia");
        javaKeywordColor.add("green");
        javaKeywordColor.add("lime");
    }

    @FXML
    public void initialize() {
        {
            outside = mainPane;
            static_outside_pane = outsidePane;
            static_button_vec.add(note0);
            static_button_vec.add(note1);
            static_button_vec.add(note2);
            static_button_vec.add(note3);
            static_button_vec.add(note4);
            static_button_vec.add(note5);
            static_button_vec.add(note6);
            static_button_vec.add(note7);
        }

        {
            NoteHandler noteHandler = new NoteHandler();
            for (Button button : static_button_vec) {
                button.addEventHandler(ActionEvent.ACTION, noteHandler);
                //button.setText("INIT");
                File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + (button.getId() + ".html"));
                String name = readFile(openFile)[0];
                if (!name.equals("Type here to name the note")) {
                    button.setText(name);
                }

            }
        }

        //initialize barchart on pane
        {
            outsidePane.setMinWidth(baseAnchorPane.getWidth());
            outsidePane.setMinHeight(baseAnchorPane.getHeight());
            mainPane.setMinWidth(baseAnchorPane.getWidth());
            mainPane.setMinHeight(baseAnchorPane.getHeight());
            mainPane.setCenter(terminalBarChart);
            terminalBarChart.setMinWidth(baseAnchorPane.getWidth());
            //terminalBarChart.setMinHeight(baseAnchorPane.getHeight());
            terminalBarChart.setMaxHeight(700);

            updateTerminalBarChart();
        }

    }

    public void initNote() {
        for (Button button : static_button_vec) {
            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + (button.getId() + ".html"));
            String name = readFile(openFile)[0];
            if (!name.equals("Type here to name the note")) {

                button.setText(name);
            }
        }
    }

    public static void setCurTerminal(Terminal curTerminal) {
        TerminalController.curTerminal = curTerminal;
    }

    class NoteHandler implements EventHandler<Event> {
        @Override
        public void handle(Event event) {
            TextField noteName = new TextField("");

            HTMLEditor htmlEditor = new HTMLEditor();
            //htmlEditor.setPrefHeight(500);
            //when pressed update
            htmlEditor.setOnKeyPressed(event1 -> {
                htmlEditor.setHtmlText(updateKeyword(htmlEditor.getHtmlText()));
            });

            ToolBar bar = null;
            Node editorToolBarNode = htmlEditor.lookup(".top-toolbar");

            if (editorToolBarNode instanceof ToolBar) {
                bar = (ToolBar) editorToolBarNode;
                //System.out.println("Size before layout pass: " + bar.getItems().size());
            }

            if (bar != null) {
                //System.out.println("Size after layout pass: " + bar.getItems().size());
                Button importButton = new Button();
                Button convertToMDButton = new Button("MD");

                convertToMDButton.setOnAction(actionEvent -> Controller.saveMD("# " + noteName.getText() + "\n" + Controller.hTMLtoMDConverter(htmlEditor.getHtmlText())));

                importButton.setOnAction(actionEvent -> {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open Image");
                    File importPath = fileChooser.showOpenDialog(new Stage());

                    htmlEditor.setHtmlText(htmlEditor.getHtmlText() + "<img src=\"" + importPath.toString() + "\">");
                });

                Image importButtonPath = new Image("file:src/sample/photo/" + "CompressedImportButtonLogo.jpg");
                importButton.setGraphic(new ImageView(importButtonPath));
                bar.getItems().add(0, importButton);
                ((Button) bar.getItems().get(0)).setMinWidth(25);
                ((Button) bar.getItems().get(0)).setMaxWidth(25);
                ((Button) bar.getItems().get(0)).setMinHeight(25);
                ((Button) bar.getItems().get(0)).setMaxHeight(25);

                bar.getItems().add(1, convertToMDButton);

                Button addCote = new Button("PG");//PG for programming
            }

            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
            String textRead = readFile(openFile)[1];
            htmlEditor.setHtmlText(textRead);
            //System.out.println("the files exists");

            System.out.println(textRead);

            Button buttonReturn = new Button("Return");
            Button buttonExport = new Button("Export");
            ToolBar noteToolBar = new ToolBar(buttonReturn, buttonExport);

            initNote();

            noteName.setText("Type here to name the note");
            //System.out.println();
            if (!((Button) event.getSource()).getText().equals("Add New Note")) {
                noteName.setText(((Button) event.getSource()).getText());
            }

            Scene scene = new Scene(new VBox(noteToolBar, noteName, htmlEditor));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setFullScreen(false);
            stage.show();

            buttonReturn.setOnAction(actionEvent -> {

                //save the current file, then return
                File openFile1 = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
                openFile1.delete();
                String stringHtml = htmlEditor.getHtmlText();
                SaveFile(stringHtml, openFile1, noteName.getText() + "<br>\n");

                if (!noteName.getText().equals("Type here to name the note"))
                    static_button_vec.get(static_button_vec.indexOf((Button) event.getSource())).setText(noteName.getText());
                stage.close();
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).setFullScreen(true);
            });

            buttonExport.setOnAction(t -> {
                String stringHtml = htmlEditor.getHtmlText();
                //htmlText.setText(stringHtml);

                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());
                if (file != null) {
                    SaveFile(stringHtml, file, "<br>\n");
                }
            });
        }
    }

    private String DeleteBR(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '<') {
                output += input.charAt(i);
            } else {
                break;
            }
        }
        return output;
    }

    private String updateKeyword(String input) {
        StringBuilder output = new StringBuilder();
        String markTOCode = "```";
        int curMarkIndex = 0;

        //output += "<div class=\"div-1\"> <hr>";

        Vector<Integer> markIndex = new Vector<>();

        if(input.contains(markTOCode)) {
            Pattern p = Pattern.compile(markTOCode);
            Matcher m = p.matcher(input);
            while(m.find()) {
                //System.out.println(m.start());
                markIndex.add(m.start());
            }
        }


        int i = 0;
        while (i < input.length()) {

            if(i==markIndex.get(curMarkIndex)) {

                //System.out.println("here");
                StringBuilder temp = new StringBuilder();
                for(int j=markIndex.get(curMarkIndex)+markTOCode.length(); j<markIndex.get(curMarkIndex+1); j++) {
                    temp.append(input.charAt(j));
                }

                System.out.println(temp);
                //output += "<b><font color='" + "red" + "'>" + temp + " " + "</font><b/>";
                output.append(checkKeyword(temp.toString()));
                i = markIndex.get(curMarkIndex+1)+markTOCode.length();
                curMarkIndex+=2;
            } else {
                output.append(input.charAt(i));
            }

            if(curMarkIndex > markIndex.size()-1) break;
            i++;
        }

        //output.append("</b></b></b>");

        //output.append("<p><span style=\"font-weight: normal;\">");

        StringBuilder temp = new StringBuilder();

        //i to length-1
        for(; i<input.length(); i++) {
            temp.append(input.charAt(i));
        }

        output.append("</b>");
        while(countKeyword > 0) {
            output.append("</b>");
            countKeyword--;
        }
        output.append(Controller.hTMLtoMDConverter(temp.toString()));
        output.append("<b>");
        while(countKeyword > 0) {
            output.append("<b>");
            countKeyword--;
        }

        //output += "<hr> </div> <style> .div-1 { background-color: #FAFAFA; font-family:Consolas;}</style> <br>";

        return output.toString();
    }

    private String checkKeyword(String input) {
        countKeyword = 0;
        boolean ifClassName = false;

        StringBuilder output = new StringBuilder();
        String[] tokens = input.split(" ");
        output.append("<div style=\"background-color: #FAFAFA; font-family:Consolas;\">");
        output.append("<hr>");

        for (String target : tokens) {
            boolean used = false;
            for (int i = 0; i < 8; i++) {
                for (String kw : javaKeyword[i]) {
                    if (target.contains(kw)) {
                        int ind = target.indexOf(kw);
                        //<b><font color='red'>Pratik</font><b/>
                        output.append(target, 0, ind).append("<b><font color='").append(javaKeywordColor.get(i)).append("'>").append(kw).append(" ").append("</font><b/>").append(target.substring(ind + kw.length()));
                        used = true;
                        countKeyword++;
                    }
                }
            }

            if(target.contains("public")) {
                ifClassName = true;
            }
            if(ifClassName) {
                ifClassName = false;
                String classNameColor = "gray";
                //output.append(" <font color=\"").append(classNameColor).append("\">").append(target).append("</font><b><b>");
            }

            if (!used) {
                output.append(target).append(" ");
            }
        }

        output.append("<hr>");
        output.append("</div><br>");
        System.out.println(output);
        System.out.println("count keyword: " + countKeyword);
        return output.toString();
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
        rt[0] = DeleteBR(noteName);
        rt[1] = stringBuffer.toString();

        return rt;
    }
    private void SaveFile(String content, File file, String buttonName) {
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(buttonName + "\n" + content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTerminalBarChart() {

        terminalBarChart.setTitle("車站完成度");
        terminalBarChartXAxis.setLabel("Type of Proficiency");
        terminalBarChartYAxis.setLabel("Proficiency Percentage");

        XYChart.Series [] series = new XYChart.Series[3];
        for(int i=0; i<3; i++) {
            series[i] = new XYChart.Series();

            int curIndex = Main.allTerminal.indexOf(curTerminal);

            //prevTerminal, curTerminal, nextTerminal
            switch (i) {
                case 0 -> {
                    series[i].setName("Previous");
                    if(curIndex == 0) {
                        curIndex=Main.stationNum-1;
                    } else curIndex--;;
                }
                case 1 -> {series[i].setName("Current");}
                case 2 -> {
                    series[i].setName("Next");
                    if(curIndex == (Main.stationNum-1)) {
                        curIndex=0;
                    } else curIndex++;
                }
                default -> {}
            }

            for(int j=0; j<4; j++) {
                series[i].getData().add(new XYChart.Data(capabilityType[j], calculateProficiency(Main.allTerminal.get(curIndex))[j]));
            }
        }

        terminalBarChart.getData().addAll(series[0], series[1], series[2]);
        terminalBarChart.setLegendSide(Side.TOP);
        terminalBarChart.setLegendVisible(true);
    }

    private double [] calculateProficiency(Terminal terminal) {
        double returnValue [] = new double[5];
        returnValue[0] = 0.0;//average
        returnValue[1] = 0.0;
        returnValue[2] = 0.0;
        returnValue[3] = 0.0;

        //File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + curTerminal.name + "/" + ((Button) event.getSource()).getId() + ".html");
        //            String textRead = readFile(openFile)[1];

        StringBuilder textTotal = new StringBuilder();
        for(int i=0; i<8; i++) {
            File openFile = new File("C:/Users/Public/Documents/JavaCodeNote/" + terminal.name + "/" + "note" + i + ".html");
            textTotal.append(readFile(openFile)[1]);
        }

        //2
        returnValue[2] = textTotal.toString().length();
        returnValue[2] = returnValue[2] % 100;
        returnValue[2] *= Math.random();

        //1
        for(int i=0; i<KeyWordAtStation.keyWord[Main.allTerminal.indexOf(terminal)].size(); i++) {
            if(textTotal.toString().contains(KeyWordAtStation.keyWord[Main.allTerminal.indexOf(terminal)].get(i))) {
                returnValue[1]++;
                //System.out.println("contain: " + KeyWordAtStation.keyWord[Main.allTerminal.indexOf(terminal)].get(i));
            }
        }
        returnValue[1] *= Math.random();

        //3
        for(int i=0; i<Main.stationNum; i++) {
            for(int j=0; j<KeyWordAtStation.keyWord[i].size(); j++) {
                if(textTotal.toString().contains(KeyWordAtStation.keyWord[i].get(j))) {
                    returnValue[3]++;
                    //System.out.println("contain: " + KeyWordAtStation.keyWord[Main.allTerminal.indexOf(terminal)].get(i));
                }
            }
        }
        returnValue[3] *= Math.random();

        //use security random here
        SecureRandom sr = new SecureRandom();

        returnValue[0] = (returnValue[1] + returnValue[2] + returnValue[3])/3.0;
        return returnValue;
    }
}
