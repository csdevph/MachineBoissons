package com.example.machineboissons;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloController implements Initializable {
    Distributeur machine = new Distributeur();

    @FXML
    ToggleGroup group5;
    @FXML
    private Label labelMachine;
    @FXML
    protected Button boutonOk;
    @FXML
    protected ComboBox cb_Choix;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelMachine.setText("Choix de boissons");

        group5.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (group5.getSelectedToggle() != null) {
                    System.out.println(group5.getSelectedToggle());
                }
            }
        });

        try {
            machine.chargerBoissons();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Boisson> boissons = machine.getBoissons();

        ArrayList<Boisson> boissonStream = (ArrayList<Boisson>) boissons.stream()
                .filter(b -> b.getTemp().equalsIgnoreCase("froid"))
                .collect(Collectors.toList());

        System.out.println("Nb boissons " + boissonStream.size());

        ObservableList<Boisson> olBoissons = FXCollections.observableArrayList(boissonStream);

        cb_Choix.setItems(olBoissons);

        cb_Choix.setCellFactory(new Callback<ListView<Boisson>, ListCell<Boisson>>() {
            @Override
            public ListCell<Boisson> call(ListView<Boisson> boissonListView) {
                return new List_Cell_Boisson();
            }
        });

    }
}