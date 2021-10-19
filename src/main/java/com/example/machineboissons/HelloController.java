package com.example.machineboissons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Distributeur machine = new Distributeur();

    @FXML
    private Label labelMachine;
    @FXML
    protected Button boutonOk;
    @FXML
    protected ComboBox cb_Choix;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelMachine.setText("Choix de boissons");

        try {
            machine.chargerBoissons();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Boisson> boissons = machine.getBoissons();
        ObservableList<Boisson> olBoissons = FXCollections.observableArrayList(boissons);

        cb_Choix.setItems(olBoissons);

        cb_Choix.setCellFactory(new Callback<ListView<Boisson>, ListCell<Boisson>>() {
            @Override
            public ListCell<Boisson> call(ListView<Boisson> boissonListView) {
                return new List_Cell_Boisson();
            }
        });

//        cb_Choix.setCellFactory((Callback<ListView<Boisson>, ListCell<Boisson>>) boissonListView -> new List_Cell_Boisson());

    }
}