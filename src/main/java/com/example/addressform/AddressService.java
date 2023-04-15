package com.example.addressform;

import com.example.addressbusinessinterface.Address;
import com.example.addressbusinessinterface.IAddressBusinessLogic;

public class AddressService {

    private IAddressBusinessLogic businessLogic;

    public AddressService(IAddressBusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    public void saveAddress(AddressModel addressModel) {
        Address addressToSave = this.getAddressFromFields(addressModel);
        this.businessLogic.saveAddress(addressToSave);
    }

    public Address getCurrentAddress() {
        return this.businessLogic.getCurrentAddress();
    }

    private Address getAddressFromFields(AddressModel model) {
        Address toSave = new Address();
        toSave.setCountry(model.getCountry());
        toSave.setStreet(model.getStreet());
        toSave.setHouseNumber(model.getHouseNumber());
        toSave.setZipCode(model.getZipCode());
        return toSave;
    }
}
