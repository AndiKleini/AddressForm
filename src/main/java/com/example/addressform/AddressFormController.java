package com.example.addressform;

import com.example.addressbusinessinterface.Address;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class AddressFormController implements Initializable {
    private final AddressModel addressMOdel;
    public TextField countryInput;
    public TextField streetInput;
    public TextField houseNumberInput;
    public TextField zipCodeInput;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public AddressFormController(AddressService service) {
        this.addressMOdel = new AddressModel(service);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var standardConverter = new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }
            @Override
            public Number fromString(String s) {
                return Integer.parseInt(s);
            };
        };
        this.countryInput.textProperty().bindBidirectional(this.addressMOdel.countryProperty());
        this.streetInput.textProperty().bindBidirectional(this.addressMOdel.streetProperty());
        this.houseNumberInput.textProperty().bindBidirectional(this.addressMOdel.houseNumberProperty(), standardConverter);
        this.zipCodeInput.textProperty().bindBidirectional(this.addressMOdel.zipCodeProperty(), standardConverter);

        this.addressMOdel.loadCurrent();
    }

    public void onSubmitAddress(ActionEvent actionEvent) {
        this.addressMOdel.save();
    }
}