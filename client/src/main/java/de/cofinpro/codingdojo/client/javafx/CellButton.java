package de.cofinpro.codingdojo.client.javafx;

import de.cofinpro.codingcojo.client.model.Position;
import de.cofinpro.codingcojo.client.model.VisibleCell;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuff on 29.08.2015.
 */
public class CellButton extends Button {

    VisibleCell visibleCell;

    private static final Map<Integer, Paint> COLOR_MAP = new HashMap<>();
    static {
        COLOR_MAP.put(1, Color.DARKBLUE);
        COLOR_MAP.put(2, Color.DARKCYAN);
        COLOR_MAP.put(3, Color.DARKGREEN);
        COLOR_MAP.put(4, Color.DARKORANGE);
        COLOR_MAP.put(5, Color.DARKRED);
        COLOR_MAP.put(7, Color.DARKVIOLET);
        COLOR_MAP.put(8, Color.DARKTURQUOISE);
    }


    public CellButton(VisibleCell cell) {
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        setPadding(new Insets(0,0,0,0));
        setStyle("-fx-font-weight: bolder; -fx-font-size: 200%");
        this.visibleCell = cell;
        if (visibleCell.isFlagged()) {
            Image image = new Image("flag.png");

            ImageView graphic = new ImageView(image);
            setGraphic(graphic);
        } else if (Boolean.TRUE.equals(visibleCell.isMine())) {
            setText("\uD83D\uDCA3");
            setTextFill(Color.WHITE);
            setStyle("-fx-background-color: red; -fx-font-weight: bolder; -fx-font-size: 200%");
        } else if (visibleCell.getNumber() > 0) {
            setText(String.valueOf(visibleCell.getNumber()));
            setTextFill(COLOR_MAP.get(visibleCell.getNumber()));
        } else if (visibleCell.getNumber() == 0) {
            setDisable(true);
            setStyle("-fx-background-color: white; -fx-font-weight: bolder; -fx-font-size: 200%;");
        }
    }

    public void setVisibleCell(VisibleCell visibleCell) {
        this.visibleCell = visibleCell;
    }

    public Position getPosition() {
        return Position.at(visibleCell.getX(), visibleCell.getY());
    }
}
