package org.exemple;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class sceneBuilder {

    @FXML
    private Label changeLabel;

    @FXML
    void changeLabel(ActionEvent event) {
        changeLabel.setText("texte changer par prog");
    }

}
