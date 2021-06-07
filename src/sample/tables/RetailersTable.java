package sample.tables;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.Retailers;

import java.io.IOException;

public class RetailersTable {
    public TableView<Retailers> Retailers() throws IOException {
        TableView<Retailers> tableView = new TableView<>();
        TableColumn<Retailers, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Retailers, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Retailers, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Retailers, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Retailers, String> products = new TableColumn<>("Products");
        products.setCellValueFactory(new PropertyValueFactory<>("products"));
        TableColumn<Retailers, String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Retailers, String> expiryDate = new TableColumn<>("Expiry Date");
        expiryDate.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        TableColumn<Retailers, String> price = new TableColumn<>("Price");
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
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000),
                new Retailers(1, "Vincent","Munene", "Beans","47 bags","23 December 2023", 450000)
        );
        return tableView;
    }
}
