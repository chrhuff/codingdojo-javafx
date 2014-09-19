package de.cofinpro.codingdojo.client;

/**
 * Created by fweichand on 19.09.2014.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.inject.Inject;

public class RandomController
{
    @FXML
    private Label label;

    @Inject
    private RandomService randomService;

    @FXML
    public void onButtonClick()
    {
        label.setText( "Random " + randomService.nextInt() );
    }
}
