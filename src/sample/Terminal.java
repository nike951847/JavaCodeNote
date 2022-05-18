package sample;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class Terminal extends Change {
    protected String name;
    protected int score;
    protected String[] noteName = new String[8];

    public Terminal() {
        name = "";
        for(int i=0;i<7;i++){
            noteName[i] = "Add New Note";
        }
    }

    public Terminal(String name) {
        this.name = name;
        for(int i=0;i<7;i++){
            noteName[i] = "Add New Note";
        }
    }

    public Terminal(int score) {
        this.score = score;
    }

    public void calculate() {
        //calculate score
    }

    public String getName() {
        return name;
    }

    public BarChart<String, Number> showChart() {
        BarChart<String, Number> scoreChart = new BarChart<String, Number>(new CategoryAxis(), new NumberAxis());
        return scoreChart;
    }
}
