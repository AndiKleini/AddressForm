package com.example.addressform;

public class ControllerFactory {

    private final AddressService addressService;

    public ControllerFactory(AddressService addressService) {
        this.addressService = addressService;
    }

    public Object create(Class<?> controller) throws Exception {
        if (controller == AddressFormController.class) {
            return new AddressFormController(this.addressService);
        }
        throw new Exception(String.format("Unsupported controller type %s", controller.getClass().toString()));
    }
}
