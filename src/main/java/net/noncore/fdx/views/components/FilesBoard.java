package net.noncore.fdx.views.components;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import net.noncore.fdx.views.View;

public class FilesBoard extends AnchorPane implements View {
    @FXML
    private TableView<FileItem> table;

   public FilesBoard() {
       load("FilesBoard.fxml");
       table.setItems(FXCollections.observableArrayList(
               new FileItem("build.gradle", "1KB", "2021-08-17 08:50"),
               new FileItem("gradlew", "6KB", "2021-08-16 22:11"),
               new FileItem("gradlew.bat", "3KB", "2021-08-16 22:11"),
               new FileItem("settings.gradle", "24B", "2021-08-16 22:11")));
   }
}
