package de.cofinpro.codingdojo.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

public class VoteRegistrationController {
    @FXML
    private Label label;
    @FXML
    private Label feedbackLabel;
    @FXML
    private TextField nameField;
    @Inject
    private EvoteService evoteService;
    @FXML
    private GridPane voterTab;

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    public void registerVoter() {
        feedbackLabel.setText("Voter " + nameField.getText() + " registered.");
        voterTab.getChildren().clear();
        try (InputStream fxml = FxMain.class.getResourceAsStream("/voterVoting.fxml")) {
            GridPane gridPane = fxmlLoader.load(fxml);
            voterTab.getChildren().addAll(gridPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
