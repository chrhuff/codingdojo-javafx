package de.cofinpro.codingdojo.client.javafx;

import de.cofinpro.codingdojo.server.api.Approval;
import de.cofinpro.codingdojo.server.api.Party;
import javafx.scene.control.ListCell;

/**
 * Created by tahmed on 20.09.2014.
 */
public class ApprovalPartyListCell extends ListCell<Approval> {
    @Override protected void updateItem(Approval item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getParty().getName());
        }
    }


}