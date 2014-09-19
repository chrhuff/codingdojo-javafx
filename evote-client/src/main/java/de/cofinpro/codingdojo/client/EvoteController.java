package de.cofinpro.codingdojo.client;

/**
 * Created by fweichand on 19.09.2014.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

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
