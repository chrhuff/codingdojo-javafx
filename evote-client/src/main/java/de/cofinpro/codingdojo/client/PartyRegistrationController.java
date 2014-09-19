package de.cofinpro.codingdojo.client;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

/**
 * Main controller. Delegate JavaFX callbacks to separate services.
 * We can use CDI here :-).
 */
public class PartyRegistrationController {
    
    @FXML 
    private Text registerPartytarget;
    
    @FXML
    private TextField partyName;
    
    @FXML 
    private GridPane registerPartyGrid;
    
    @Inject
    private FXMLLoader fxmlLoader;
    
    @FXML
    public void onRegisterPartyClick() throws IOException {
    	if(!partyName.getText().trim().equals("")){
	    	registerPartytarget.setText("Party" + partyName.getText() + " registered.");
	    	
	    	//REST PUT
	    	
	    	registerPartyGrid.getChildren().clear();
	        try (InputStream fxml = FxMain.class.getResourceAsStream("/partyElection.fxml")) {
	            GridPane gridPane = fxmlLoader.load(fxml);
	            registerPartyGrid.getChildren().addAll(gridPane.getChildren());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    	}
    }

}
