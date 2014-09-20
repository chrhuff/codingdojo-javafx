package de.cofinpro.codingdojo.client.javafx;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;
import javafx.scene.control.ListCell;

/**
 * Created by tahmed on 20.09.2014.
 */
public class PartyListCell extends ListCell<Party> {
    @Override protected void updateItem(Party item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getName());
        }
    }


}