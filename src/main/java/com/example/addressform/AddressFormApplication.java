package com.example.addressform;

import com.example.addressbusiness.ConcreteAddressBusinessLogic;
import com.example.addressbusinessinterface.IAddressBusinessLogic;
import com.example.addressdatalayer.ConcreteAddressDataLayer;
import com.example.addressdatalayerinterface.IAddressDataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddressFormApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        IAddressDataSource dataSource = new ConcreteAddressDataLayer();
        IAddressBusinessLogic business = new ConcreteAddressBusinessLogic(dataSource);
        ControllerFactory factory =
                new ControllerFactory(
                        new AddressService(business));
        FXMLLoader fxmlLoader = new FXMLLoader(
                AddressFormApplication.class.getResource("hello-view.fxml"),
                null,
                new JavaFXBuilderFactory(),
                controller -> {
                    try {
                        return factory.create(controller);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Address Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}