package de.cofinpro.codingdojo.client;

import javafx.application.Application.Parameters;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class loads the stage from fxml. We should not need to modify this, edit the fxml
 * to create a layout or add components instead.
 */
public class FxMain {
    @Inject
    //This is our own 'CDI-enabled' fxml loader.
    private FXMLLoader fxmlLoader;

    public void start(Stage stage, Parameters parameters) throws IOException {
        try (InputStream fxml = FxMain.class.getResourceAsStream("/main.fxml")) {
            Scene scene = new Scene(fxmlLoader.load(fxml));
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Minesweeper RESTfx HD");
            stage.setResizable(true);
        }
    }
}