package net.noncore.fdx.views.components;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import net.noncore.fdx.views.View;

public class FilesBoard extends GridPane implements View {
    @FXML
    private VBox left;
    @FXML
    private VBox right;

   public FilesBoard() {
       load("FilesBoard.fxml");
       left.getChildren().add(new FileLine());
       right.getChildren().add(new FileLine());
   }
}
