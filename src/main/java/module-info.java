module com.example.machineboissons {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.machineboissons to javafx.fxml;
    exports com.example.machineboissons;
}