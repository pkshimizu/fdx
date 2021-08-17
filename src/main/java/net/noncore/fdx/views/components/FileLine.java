package net.noncore.fdx.views.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import net.noncore.fdx.views.View;

public class FileLine extends AnchorPane implements View {
    @FXML
    private Label name;
    @FXML
    private Label size;
    @FXML
    private Label date;

    public FileLine() {
        load("FileLine.fxml");
    }
}
