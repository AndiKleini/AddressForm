package com.example.addressdatalayer;

import com.example.addressdatalayerinterface.AddressDTO;
import com.example.addressdatalayerinterface.IAddressDataSource;

public class ConcreteAddressDataLayer implements IAddressDataSource {

    private AddressDTO currentDTO =
            new AddressDTO(){
                {
                    setHouseNumber(1);
                    setZipCode(1223);
                    setCountry("AT");
                    setStreet("Hauptstrasse");
                }};

    @Override
    public void saveAddress(AddressDTO address) {
        this.currentDTO = address;
    }

    @Override
    public AddressDTO getCurrentAddress() {
        return this.currentDTO;
    }
}
