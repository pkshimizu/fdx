package net.noncore.fdx.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public interface View<T extends Parent> {
    default void load(String name) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
