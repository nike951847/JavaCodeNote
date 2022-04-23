import javafx.scene.chart.BarChart;
import sample.Change;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Terminal extends Change {
    protected int whichLine;
    protected int score;

    public Terminal() {}

    public Terminal(int score) {
        this.score = score;
    }

    public void calculate() {
        //calculate score
    }

    public BarChart<String, Number> showChart() {
        BarChart<String, Number> scoreChart = new BarChart<String, Number>(new CategoryAxis(), new NumberAxis());
        return scoreChart;
    }
}
