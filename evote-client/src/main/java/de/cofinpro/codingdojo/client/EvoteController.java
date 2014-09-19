package de.cofinpro.codingdojo.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

/**
 * Main controller. Delegate JavaFX callbacks to separate services.
 * We can use CDI here :-).
 */
public class EvoteController {
    @FXML
    private Label label;

    @Inject
    private EvoteService evoteService;

    @FXML
    public void onButtonClick() {
        label.setText("Random " + evoteService.nextInt());
    }
}
