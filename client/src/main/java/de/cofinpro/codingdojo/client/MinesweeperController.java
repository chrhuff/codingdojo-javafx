package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.client.service.MinesweeperService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller. Delegate JavaFX callbacks to separate services.
 * We can use CDI here :-).
 */
public class MinesweeperController implements Initializable {

    @FXML
    private GridPane minefieldGrid;

    @FXML
    private Pane root;

    @Inject
    private MinesweeperService minesweeperService;

    private int sessionId = -1;

    @FXML
    public void onGridLeftMouseClick() {


    }

    public void onGridRightMouseClick() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        minefieldGrid.setVisible(true);
    }
}
