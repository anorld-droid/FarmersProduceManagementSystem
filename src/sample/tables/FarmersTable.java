package sample.tables;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.Farmers;

import java.io.IOException;

public class FarmersTable {
    public TableView<Farmers> Farmers() throws IOException {
        TableView<Farmers> tableView = new TableView<>();
        TableColumn<Farmers, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Farmers, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Farmers, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Farmers, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Farmers, String> products = new TableColumn<>("Products");
        products.setCellValueFactory(new PropertyValueFactory<>("products"));
        TableColumn<Farmers, String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Farmers, String> expiryDate = new TableColumn<>("Expiry Date");
        expiryDate.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        TableColumn<Farmers, String> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        name.getColumns().addAll(firstName, lastName);
        id.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        id.resizableProperty().setValue(false);
        firstName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        firstName.resizableProperty().setValue(false);
        lastName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        lastName.resizableProperty().setValue(false);
        products.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        products.resizableProperty().setValue(false);
        quantity.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        quantity.resizableProperty().setValue(false);
        expiryDate.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        expiryDate.resizableProperty().setValue(false);
        price.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        price.resizableProperty().setValue(false);

        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().add(id);
        tableView.getColumns().add(name);
        tableView.getColumns().add(products);
        tableView.getColumns().add(quantity);
        tableView.getColumns().add(expiryDate);
        tableView.getColumns().add(price);
        tableView.getItems().addAll(
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000),
                new Farmers(1, "Wanjala", "Patrice","Maize","500 bags", "2 July 2022", 730000)
        );
        return tableView;
    }
}
