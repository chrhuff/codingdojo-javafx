package de.cofinpro.codingdojo.client;

import java.io.*;

import javafx.application.Application.Parameters;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import javax.inject.Inject;

/**
 * This class loads the stage from fxml. We should not need to modify this, edit the fxml
 * to create a layout or add components instead.
 */
public class FxMain {
    @Inject
    //This is our own 'CDI-enabled' fxml loader.
    private FXMLLoader fxmlLoader;

    public void start(Stage stage, Parameters parameters) throws IOException {
        try (InputStream fxml = EvoteController.class.getResourceAsStream("/evote.fxml")) {
            stage.setScene(new Scene(fxmlLoader.load(fxml)));
            stage.show();
        }
    }
}