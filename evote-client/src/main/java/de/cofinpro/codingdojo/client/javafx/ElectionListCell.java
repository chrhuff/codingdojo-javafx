package de.cofinpro.codingdojo.client.javafx;

import de.cofinpro.codingdojo.server.api.Election;
import javafx.scene.control.ListCell;

/**
 * Created by tahmed on 20.09.2014.
 */
public class ElectionListCell extends ListCell<Election> {
    @Override protected void updateItem(Election item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getName());
        }
    }


}