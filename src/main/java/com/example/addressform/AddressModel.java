package com.example.addressform;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddressModel {

    private StringProperty country = new SimpleStringProperty();
    private StringProperty street = new SimpleStringProperty();
    private IntegerProperty zipCode = new SimpleIntegerProperty();
    private IntegerProperty houseNumber = new SimpleIntegerProperty();

    public StringProperty countryProperty()  {
        return country;
    }

    public String getCountry() {
        return this.country.get();
    }

    public void setCountry(String value)  {
        this.country.set(value);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getZipCode() {
        return zipCode.get();
    }

    public IntegerProperty zipCodeProperty() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode.set(zipCode);
    }

    public int getHouseNumber() {
        return houseNumber.get();
    }

    public IntegerProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public void save() {
        this.street.set("Bussigasse");
    }
}
