package com.example.addressdatalayerinterface;

import com.example.addressbusinessinterface.Address;

public interface IAddressDataSource {
    public void saveAddress(AddressDTO address);

    public AddressDTO getCurrentAddress();
}
