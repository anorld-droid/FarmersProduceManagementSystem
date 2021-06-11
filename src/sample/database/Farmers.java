package sample.database;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Farmers {
    //A class of farmer that generates properties to be mapped to
    //data from the database
    public IntegerProperty id = new SimpleIntegerProperty();
    public IntegerProperty phoneNumber = new SimpleIntegerProperty();
    public StringProperty firstName = new SimpleStringProperty();
    public StringProperty lastName = new SimpleStringProperty();
    public StringProperty products = new SimpleStringProperty();
    public StringProperty unit = new SimpleStringProperty();
    public IntegerProperty amount = new SimpleIntegerProperty();
    public IntegerProperty price = new SimpleIntegerProperty();


    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty productsProperty() {
        return products; }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public StringProperty unitProperty() {
        return unit;
    }

    public Farmers(int idValue, String productsValue, String unitValue, int amountValue, String firstNameValue, String lastNameValue, int priceValue, String quantityValue){
        id.setValue(idValue);
        firstName.setValue(firstNameValue);
        lastName.setValue(lastNameValue);
        products.setValue(productsValue);
        amount.setValue(amountValue);
        unit.setValue(unitValue);
        price.setValue(priceValue);
    }

    public Farmers(){}
}
