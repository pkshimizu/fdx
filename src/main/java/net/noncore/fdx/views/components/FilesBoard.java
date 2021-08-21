package net.noncore.fdx.views.components;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import net.noncore.fdx.views.View;

import java.util.List;

public class FilesBoard extends GridPane implements View {
    @FXML
    private VBox left;
    @FXML
    private VBox right;
    private int lineCount = 0;
    private List<FileLine> lines = List.of(
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine(),
            new FileLine());

   public FilesBoard() {
       load("FilesBoard.fxml");
       heightProperty().addListener(((observable, oldValue, newValue) -> {
           int count = newValue.intValue() / 32;
           if (lineCount < count) {
               if (lines.size() > lineCount) {
                   for(int index = lineCount; index < count; index++) {
                       left.getChildren().add(lines.get(index));
                       right.getChildren().remove(lines.get(index));
                   }
                   for (int index = count; index < lines.size(); index++) {
                       if (right.getChildren().indexOf(lines.get(index)) < 0) {
                           right.getChildren().add(lines.get(index));
                       }
                   }
               }
           }
           lineCount = count;
       }));
   }
}
