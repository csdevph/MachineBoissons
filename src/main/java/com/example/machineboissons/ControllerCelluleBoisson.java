package com.example.machineboissons;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCelluleBoisson implements Initializable {
    @FXML
    Label labelNom;

    @FXML
    Label labelPrix;

    @FXML
    ImageView imgView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelNom.setText("Coca");
    }
}
