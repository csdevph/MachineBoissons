package com.example.machineboissons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
    protected ComboBox<Boisson> cb_Choix;

    @FXML
    protected ComboBox<Image> cb_Images;

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

        ObservableList<String> ol = FXCollections.observableArrayList("kk", "pp");
        cb_Choix.setButtonCell(new ListCell<>());
        cb_Choix.setItems(olBoissons);

        Callback<ListView<Boisson>, ListCell<Boisson>> cellFacto = cb_Choix.getCellFactory();
        System.out.println( cb_Choix.getCellFactory());

        /*
        ObservableList<Image> data = FXCollections.observableArrayList();
        //data.add(new Image("file:C:\\Users\\phs\\IdeaProjects\\MachineBoissons\\src\\main\\resources\\com\\example\\machineboissons\\abc_text_dark.png"));
        data.add(new Image("file://abc_text_light.png"));
        System.out.println(data.size());
        cb_Images.setItems(data);

         */
    }
}