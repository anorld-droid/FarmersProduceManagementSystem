package sample.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.DatabaseConnection;
import sample.database.Farmers;
import sample.database.Retailers;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FarmersTable {
    DatabaseConnection conn = new DatabaseConnection();
    Connection connection = conn.connect();
    public TableView<Farmers> Farmers() throws IOException {
        //Creates and returns the table to be displayed in the ui
        TableView<Farmers> tableView = new TableView<>();
        TableColumn<Farmers, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Farmers, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Farmers, String> firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Farmers, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Farmers, Integer> phoneNumber = new TableColumn<>("Phone Number");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn<Farmers, String> products = new TableColumn<>("Products");
        products.setCellValueFactory(new PropertyValueFactory<>("products"));
        TableColumn<Farmers, String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Farmers, String> amount = new TableColumn<>("Amount");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<Farmers, Integer> unit = new TableColumn<>("Unit");
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        TableColumn<Farmers, Integer> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        name.getColumns().addAll(firstName, lastName);
        quantity.getColumns().addAll(amount, unit);
        id.prefWidthProperty().bind(tableView.widthProperty().multiply(0.05));
        id.resizableProperty().setValue(false);
        firstName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        firstName.resizableProperty().setValue(false);
        lastName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        lastName.resizableProperty().setValue(false);
        phoneNumber.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        phoneNumber.resizableProperty().setValue(false);
        products.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        products.resizableProperty().setValue(false);
        amount.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        amount.resizableProperty().setValue(false);
        unit.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        unit.resizableProperty().setValue(false);
        price.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        price.resizableProperty().setValue(false);

        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().add(id);
        tableView.getColumns().add(name);
        tableView.getColumns().add(phoneNumber);
        tableView.getColumns().add(products);
        tableView.getColumns().add(quantity);
        tableView.getColumns().add(price);

        return tableView;
    }
    public TableView<Farmers> FarmersData() throws IOException{
        TableView<Farmers> tableView = Farmers();
        try{

            //Gets content from the database creates and pass it to an
            //database Array list function defined below then later
            //stores the arraylist returned to an observable list
            //which is passed to tableView for display
            String SQL = "SELECT * FROM Farmers , Products WHERE farmers.products_id = products.id;";
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);
            System.out.println(resultSet);
            ObservableList data = FXCollections.observableArrayList(dataBaseArrayList(resultSet));
            tableView.setItems(data);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());

            }
        }
        return  tableView;
    }

    private ArrayList dataBaseArrayList(ResultSet resultSet) throws  SQLException{
        ArrayList<Farmers> data = new ArrayList<>();
        int id = 1;
        //Maps data from the database to the respective property defined in the
        //farmers class then returns it in an arraylist
        while (resultSet.next()){
            Farmers farmers = new Farmers();
            farmers.id.set(id);
            farmers.firstName.set(resultSet.getString("firstName"));
            farmers.lastName.set(resultSet.getString("lastName"));
            farmers.phoneNumber.set(resultSet.getInt("phoneNumber"));
            farmers.products.set(resultSet.getString("Name"));
            farmers.amount.set(resultSet.getInt("amount"));
            farmers.unit.set(resultSet.getString("unit"));
            farmers.price.set(resultSet.getInt("price"));
            data.add(farmers);
            id++;
        }
        return data;
    }

}
