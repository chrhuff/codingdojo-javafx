package de.cofinpro.codingdojo.client;

import de.cofinpro.codingcojo.client.model.Action;
import de.cofinpro.codingcojo.client.model.ActionResult;
import de.cofinpro.codingcojo.client.model.ClientStatus;
import de.cofinpro.codingcojo.client.model.VisibleCell;
import de.cofinpro.codingdojo.client.javafx.CellButton;
import de.cofinpro.codingdojo.client.service.InitGameRequest;
import de.cofinpro.codingdojo.client.service.MinesweeperService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        HBox.setHgrow(minefieldGrid, Priority.ALWAYS);
        VBox.setVgrow(minefieldGrid, Priority.ALWAYS);
        minefieldGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        minefieldGrid.setPadding(new Insets(0));
        minefieldGrid.setVisible(true);
        minefieldGrid.setGridLinesVisible(false);
        final int width = 10;
        final int height = 10;
        for (int i = 0; i < width; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / width);
            minefieldGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < height; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / height);
            minefieldGrid.getRowConstraints().add(rowConst);
        }

        InitGameRequest request = new InitGameRequest();
        request.setHeight(height);
        request.setWidth(width);
        request.setMineRatio(0.1f);
        sessionId = minesweeperService.initGame(request);

        ActionResult currentGameState = minesweeperService.getCurrentGameState(sessionId);
        paintVisibleCells(currentGameState);
    }

    private void paintVisibleCells(ActionResult currentGameState) {
        minefieldGrid.getChildren().removeAll();
        for (VisibleCell visibleCell : currentGameState.getVisibleCells()) {
            final CellButton node = new CellButton(visibleCell);
            node.setOnMouseClicked(e -> {
                if (!node.isDisabled()) {
                    MouseButton mouseButton = e.getButton();
                    if (mouseButton == MouseButton.PRIMARY) {
                        mouseClicked(node, Action.Type.UNCOVER);
                    } else if (mouseButton == MouseButton.SECONDARY) {
                        mouseClicked(node, Action.Type.FLAG);
                    } else if (mouseButton == MouseButton.MIDDLE) {
                        mouseClicked(node, Action.Type.SOLVE);
                    }
                }
            });
            minefieldGrid.add(node, visibleCell.getX(), visibleCell.getY());
        }
    }

    private void mouseClicked(CellButton button, Action.Type type) {
        Action action = new Action();
        action.setType(type);
        action.setPosition(button.getPosition());
        ActionResult result = minesweeperService.submitAction(sessionId, action);
        receiveActionResult(result);
    }

    private void receiveActionResult(ActionResult result) {
        paintVisibleCells(result);
        if (result.getStatus() == ClientStatus.GAMEOVER) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game Over!");
            alert.show();
            minefieldGrid.getChildren().stream().forEach( n -> n.setDisable(true));
        } else if (result.getStatus() == ClientStatus.VICTORY) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You win!");
            alert.show();
            minefieldGrid.getChildren().stream().forEach( n -> n.setDisable(true));
        }
    }
}
