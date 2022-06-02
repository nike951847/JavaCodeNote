package sample.FileExport;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.NoteBlock;

import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import javafx.scene.Node;

public class SaveFileText {
    public SaveFileText(Vector<NoteBlock> vector) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Documents (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(new Stage());

            FileWriter fileWriter;
            fileWriter = new FileWriter(file);

            StringBuffer stringBuffer = new StringBuffer();
            for(NoteBlock noteBlock: vector) {
                switch (noteBlock.comboBox.getValue()) {
                    case "Markdown" -> {
                        //ad
                    }

                    case "Text", "Callout", "Link to page" -> {
                        fileWriter.write(((TextArea)((Node)(noteBlock.hBox.getChildren().get(0)))).getText());
                    }

                    case "Page" -> {
                        //scv
                    }

                    case "To-do list" -> {
                        fileWriter.write(((TextField)((Node)(noteBlock.hBox.getChildren().get(1)))).getText());
                    }

                    case "Heading 1", "Heading 2", "Heading 3" -> {
                        fileWriter.write(((TextField)((Node)(noteBlock.hBox.getChildren().get(0)))).getText());
                    }

                    case "Table" -> {
                        //sd
                    }

                    case "Bulledted list", "Numbered list" -> {
                        ((ListView)((Node)(noteBlock.hBox.getChildren().get(0)))).getItems().size();
                        for(int i=0; i<((ListView)((Node)(noteBlock.hBox.getChildren().get(0)))).getItems().size(); i++) {
                            fileWriter.write(((ListView)((Node)(noteBlock.hBox.getChildren().get(0)))).getItems().get(i).toString());
                            if(i != ((ListView)((Node)(noteBlock.hBox.getChildren().get(0)))).getItems().size()-1) {
                                fileWriter.write("\n");
                            }
                        }
                    }

                    case "Code" -> {

                    }

                    case "Toggle list" -> {
                        //ssdfs
                    }

                    case "Quote" -> {
                        //sdfsf
                    }

                    case "Divider" -> {
                        //qef
                    }
                }
                fileWriter.write("\n");
            }

            fileWriter.close();

        } catch (Exception e) {System.out.println("error");}
    }
}
