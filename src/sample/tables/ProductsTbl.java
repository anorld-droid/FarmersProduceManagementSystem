package sample.tables;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.database.DatabaseConnection;
import sample.database.Farmers;
import sample.database.Products;
import sample.database.Retailers;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ProductsTbl  {
    private ObservableList<ObservableList> data;
    DatabaseConnection conn = new DatabaseConnection();
    Connection connection = conn.connect();

    public TableView Products() {
        //Creates and returns the table to be displayed in the ui

        TableView<Products> tableView = new TableView();
        TableColumn<Products, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Products, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Products, String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<Products, String> expiryDate = new TableColumn<>("Expiry Date");
        expiryDate.setCellFactory(TextFieldTableCell.forTableColumn());
        expiryDate.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        TableColumn<Products, String> amount = new TableColumn<>("Amount");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<Products, Integer> unit = new TableColumn<>("Unit");
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        quantity.getColumns().addAll(amount, unit);
        id.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        id.resizableProperty().setValue(false);
        name.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        name.resizableProperty().setValue(false);
        amount.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        amount.resizableProperty().setValue(false);
        unit.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        unit.resizableProperty().setValue(false);
        expiryDate.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        quantity.resizableProperty().setValue(false);
        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().add(id);
        tableView.getColumns().add(name);
        tableView.getColumns().add(quantity);
        tableView.getColumns().add(expiryDate);

        return tableView;
    }

    public TableView<Products> ProductsData() throws IOException{
        TableView<Products> tableView = Products();
        Statement statement = null;


        try{
            //Gets content from the database creates and pass it to an
            //database Array list function defined below then later
            //stores the arraylist returned to an observable list
            //which is passed to tableView for display
            statement = connection.createStatement();
            String farmerProductsSql = "select Products.expiryDate as \"ExpiryDate\", Name,  sum (amount) as \"Amount\" , unit as \"Unit\" from Farmers, Products\n" +
                    "   where Farmers.Products_id = products.id group by Name ";
            String retailerProducts = "select Name,  sum (amount) as rAmount  from Retailers, Products\n" +
                    "   where Retailers.Products_id = products.id group by Name ";
            ResultSet resultSet = connection.createStatement().executeQuery(retailerProducts);
            ResultSet farmersProduct = connection.createStatement().executeQuery(farmerProductsSql);
            ObservableList data = FXCollections.observableArrayList(dataBaseArrayList(farmersProduct, resultSet));
            tableView.setItems(data);
            farmersProduct.close();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    statement.close();
                    connection.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return  tableView;
    }

    private ArrayList dataBaseArrayList(ResultSet farmersProducts, ResultSet retailerProducts) throws  SQLException{
        ArrayList<Products> data = new ArrayList<>();
        int id = 1;
        //Maps data from the database to the respective property defined in the
        //products class then returns it in an arraylist
        while (farmersProducts.next()){
            Products products = new Products();
            products.id.set(id);
            products.name.set(farmersProducts.getString("Name"));
            if (retailerProducts.next()) {
                if (farmersProducts.getString("Name").equals(retailerProducts.getString("Name"))) {
                    products.amount.set(farmersProducts.getInt("Amount") - retailerProducts.getInt("rAmount"));
                    System.out.println(retailerProducts.getInt("rAmount"));
                } else {
                    products.amount.set(farmersProducts.getInt("Amount"));
                }
            }else {
                products.amount.set(farmersProducts.getInt("Amount"));
            }
            products.unit.set(farmersProducts.getString("Unit"));
            products.expiryDate.set(farmersProducts.getString(1));
            data.add(products);
            id++;
        }
        return data;

    }
}
