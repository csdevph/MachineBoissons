package com.example.machineboissons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

public class List_Cell_Boisson extends ListCell<Boisson> {
    @FXML
    AnchorPane cellPane;

    @FXML
    Label labelNom;

    @Override
    protected void updateItem(Boisson boisson, boolean b) {
        super.updateItem(boisson, b);
    }
}
