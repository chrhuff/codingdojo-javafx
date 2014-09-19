package de.cofinpro.codingdojo.client;

import java.io.*;

import javafx.application.Application.Parameters;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import javax.inject.Inject;

public class FxMain {
    @Inject
    private FXMLLoader fxmlLoader;

    public void start(Stage stage, Parameters parameters) throws IOException {
        try (InputStream fxml = RandomController.class.getResourceAsStream("/evote.fxml")) {
            Parent root = fxmlLoader.load(fxml);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}