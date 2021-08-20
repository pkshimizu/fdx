package net.noncore.fdx.views;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import net.noncore.fdx.views.components.FilesBoard;

public class MainView extends AnchorPane implements View {
    @FXML
    private FilesBoard filesBoard;

    public MainView() {
        load("MainView.fxml");
    }

}
