package sample.database;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Products {
    //A class of Products that generates properties to be mapped to
    //data from the database
    public IntegerProperty id = new SimpleIntegerProperty();
    public StringProperty name = new SimpleStringProperty();
    public IntegerProperty amount = new SimpleIntegerProperty();
    public StringProperty unit = new SimpleStringProperty();
    public StringProperty expiryDate = new SimpleStringProperty();

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty(){
        return name;
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public StringProperty unitProperty() {
        return unit;
    }

    public StringProperty expiryDateProperty() {
        return expiryDate;
    }

    public Products(int idValue, String nameValue, int amountValue ,String unitValue, String expiryDateValue){
       id.setValue(idValue);
       name.setValue(nameValue);
       amount.setValue(amountValue);
       unit.setValue(unitValue);
       expiryDate.setValue(expiryDateValue);
    }
    public Products(){}
}
