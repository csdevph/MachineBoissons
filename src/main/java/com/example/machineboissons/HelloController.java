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

public class HelloController implements Initializable {
    Distributeur machine = new Distributeur();
    // Filtrage
    ArrayList<Boisson> boissons;
    ArrayList<Boisson> boissonStream;
    ObservableList<Boisson> olBoissons;

    @FXML
    ToggleGroup group5;
    @FXML
    RadioButton rdChaud;
    @FXML
    RadioButton rdFroid;
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

        boissons = machine.getBoissons();
//        filtrage("froid");

        cb_Choix.setCellFactory(new Callback<ListView<Boisson>, ListCell<Boisson>>() {
            @Override
            public ListCell<Boisson> call(ListView<Boisson> boissonListView) {
                return new List_Cell_Boisson();
            }
        });

        group5.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (group5.getSelectedToggle() != null) {
                    RadioButton btn = (RadioButton) t1;
                    String typeBoisson = btn.getText();
                    System.out.println(typeBoisson);
                    filtrage(typeBoisson);
                }
            }
        });

        rdFroid.setSelected(true);
    }

    void filtrage(String typeBoisson) {
        boissonStream = (ArrayList<Boisson>) boissons.stream()
                .filter(b -> b.getTemp().equalsIgnoreCase(typeBoisson))
                .collect(Collectors.toList());
        olBoissons = FXCollections.observableArrayList(boissonStream);
        cb_Choix.setValue("Votre choix");
        cb_Choix.setItems(olBoissons);

        // combo box not updating dropdown size upon change : quick trick
        cb_Choix.show();
        cb_Choix.hide();

        System.out.println("Nb boissons " + boissonStream.size());
    }
}