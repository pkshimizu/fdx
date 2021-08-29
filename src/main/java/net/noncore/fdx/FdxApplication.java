package net.noncore.fdx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.noncore.fdx.domains.services.TaskService;
import net.noncore.fdx.views.MainView;

import java.io.IOException;

public class FdxApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new MainView(), 320, 240);
        stage.setTitle("fdx");
        stage.setScene(scene);
        stage.setOnCloseRequest((event) -> {
            TaskService.getInstance().shutdown();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}