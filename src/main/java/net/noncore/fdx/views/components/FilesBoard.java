package net.noncore.fdx.views.components;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import net.noncore.fdx.views.View;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class FilesBoard extends AnchorPane implements View {
    @FXML
    private TableView<FileItem> table;

    private static final List<String> FILE_SIZE_UNITS = Arrays.asList("Bite", "KB", "MB", "GB", "TB");

   public FilesBoard() {
       load("FilesBoard.fxml");
       try {
           Files.list(Path.of(System.getProperty("user.home"))).forEach(path -> {
               try {
                   Path name = path.getFileName();
                   long size = Files.size(path);
                   LocalDateTime date = Files.getLastModifiedTime(path).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                   table.getItems().add(new FileItem(name.toString(), toSizeText(size, FILE_SIZE_UNITS), date.format(DateTimeFormatter.ISO_DATE)));
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           });
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   private String toSizeText(long size, List<String> units) {
        if (size < 1024) {
            return String.format("%d %s", size, units.get(0));
        }
        return toSizeText(size / 1024, units.subList(1, units.size()));
   }
}
