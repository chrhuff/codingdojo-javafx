package de.cofinpro.codingdojo.client;

import de.cofinpro.codingcojo.client.model.Action;
import de.cofinpro.codingcojo.client.model.ActionResult;
import de.cofinpro.codingcojo.client.model.ClientStatus;
import de.cofinpro.codingcojo.client.model.VisibleCell;
import de.cofinpro.codingdojo.client.javafx.CellButton;
import de.cofinpro.codingcojo.client.model.InitGameRequest;
import de.cofinpro.codingdojo.service.MinesweeperService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller. Delegate JavaFX callbacks to separate services.
 * We can use CDI here :-).
 */
public class MinesweeperController implements Initializable {

    private static final float MINE_RATIO = 0.1f;
    private static final int WIDTH = 16;
    private static final int HEIGHT = 10;

    @FXML
    private GridPane minefieldGrid;

    @Inject
    private MinesweeperService minesweeperService;

    private int sessionId = -1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        HBox.setHgrow(minefieldGrid, Priority.ALWAYS);
        VBox.setVgrow(minefieldGrid, Priority.ALWAYS);
        minefieldGrid.setPrefSize(800,500);
        minefieldGrid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        minefieldGrid.setPadding(new Insets(5));
        minefieldGrid.setVisible(true);
        minefieldGrid.setGridLinesVisible(false);
        for (int i = 0; i < WIDTH; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / WIDTH);
            minefieldGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < HEIGHT; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / HEIGHT);
            minefieldGrid.getRowConstraints().add(rowConst);
        }

        startNewGame(WIDTH, HEIGHT, 0.1f);
    }

    private void startNewGame(int width, int height, float mineRatio) {
        InitGameRequest request = getInitGameRequest(width, height, mineRatio);
        sessionId = minesweeperService.initGame(request);
        ActionResult currentGameState = minesweeperService.getCurrentGameState(sessionId);
        paintVisibleCells(currentGameState);
    }

    private InitGameRequest getInitGameRequest(int width, int height, float mineRatio) {
        InitGameRequest request = new InitGameRequest();
        request.setHeight(height);
        request.setWidth(width);
        request.setMineRatio(mineRatio);
        return request;
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
            alert.showAndWait();
            minefieldGrid.getChildren().forEach(n -> n.setDisable(true));
            startNewGame(WIDTH, HEIGHT, MINE_RATIO);
        } else if (result.getStatus() == ClientStatus.VICTORY) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You win!");
            alert.showAndWait();
            minefieldGrid.getChildren().forEach(n -> n.setDisable(true));
            startNewGame(WIDTH, HEIGHT, MINE_RATIO);
        }
    }
}
