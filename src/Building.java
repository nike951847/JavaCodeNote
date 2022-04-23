import javafx.scene.Node;
import javafx.scene.paint.Color;
import sample.Change;

public class Building extends Change {
    protected Terminal whichTerminal;
    protected int relativePosition;
    protected Color color;
    protected int height;
    //Note notes

    public Building() {}

    public Building(Terminal whichTerminal, int relativePosition, Color color, int height/*Note notes*/) {
        this.whichTerminal = whichTerminal;
        this.relativePosition = relativePosition;
        this.color = color;
        this.height = height;
    }

    @Override
    public Node draw() {
        return super.draw();
    }

    public void editNote() {

    }

    public void setHeight(int height) {
        this.height = height;
    }
}
