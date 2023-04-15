package com.example.addressbusiness;

import com.example.addressbusinessinterface.Address;
import com.example.addressbusinessinterface.IAddressBusinessLogic;
import com.example.addressdatalayerinterface.AddressDTO;
import com.example.addressdatalayerinterface.IAddressDataSource;

public class ConcreteAddressBusinessLogic implements IAddressBusinessLogic {

    private final IAddressDataSource dataSource;

    public ConcreteAddressBusinessLogic(IAddressDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveAddress(Address toSave) {
        if (toSave.getCountry() == "DE") {
            return;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry(toSave.getCountry());
        addressDTO.setHouseNumber(toSave.getHouseNumber());
        addressDTO.setStreet(toSave.getStreet());
        addressDTO.setZipCode(toSave.getZipCode());
        this.dataSource.saveAddress(addressDTO);
    }

    @Override
    public Address getCurrentAddress() {
        AddressDTO addressDTO = this.dataSource.getCurrentAddress();
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setHouseNumber(addressDTO.getHouseNumber());
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());
        return address;
    }
}
