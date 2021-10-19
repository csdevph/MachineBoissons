package com.example.machineboissons;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class List_Cell_Boisson extends ListCell<Boisson> {
    FXMLLoader mLoader;

    @FXML
    AnchorPane cellPane;
    @FXML
    Label labelNom;
    @FXML
    Label labelPrix;
    @FXML
    ImageView imgView;

    @Override
    protected void updateItem(Boisson boisson, boolean empty) {
        super.updateItem(boisson, empty);
        if (empty || boisson == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLoader == null) {
                mLoader = new FXMLLoader(getClass().getResource("CelluleBoisson.fxml"));
                mLoader.setController(this);
                try {
                    mLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            labelNom.setText(boisson.getNom());
            labelPrix.setText(boisson.getPrix() + "");
            imgView.setImage(boisson.getImage());
            setGraphic(cellPane);
        }
    }
}
