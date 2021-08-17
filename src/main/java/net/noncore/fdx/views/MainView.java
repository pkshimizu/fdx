package net.noncore.fdx.views;

import javafx.scene.layout.AnchorPane;
import net.noncore.fdx.views.components.FilesBoard;

public class MainView extends AnchorPane implements View {

    public MainView() {
        load("MainView.fxml");
        getChildren().add(new FilesBoard());
    }

}
