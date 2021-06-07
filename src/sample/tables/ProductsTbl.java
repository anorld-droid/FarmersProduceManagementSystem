package sample.tables;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.Products;

import java.io.IOException;

public class ProductsTbl  {

    public TableView<Products> Products() throws IOException {
        TableView<Products> tableView = new TableView<>();
        TableColumn<Products, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Products, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Products, String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Products, String> expiryDate = new TableColumn<>("Expiry Date");
        expiryDate.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));


        id.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        id.resizableProperty().setValue(false);
        name.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        name.resizableProperty().setValue(false);
        quantity.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        quantity.resizableProperty().setValue(false);
        expiryDate.prefWidthProperty().bind(tableView.widthProperty().multiply(0.35));
        quantity.resizableProperty().setValue(false);
        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().add(id);
        tableView.getColumns().add(name);
        tableView.getColumns().add(quantity);
        tableView.getColumns().add(expiryDate);

        tableView.getItems().addAll(new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020"),
        new Products(1, "Maize", "20 bags","12 June 2020")
        );
        return tableView;
    }

}
