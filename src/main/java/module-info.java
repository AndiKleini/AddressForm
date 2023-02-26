module com.example.adressform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.addressform to javafx.fxml;
    exports com.example.addressform;
}