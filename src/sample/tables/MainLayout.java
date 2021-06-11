package sample.tables;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.database.DatabaseConnection;
import sample.database.Farmers;
import sample.database.Products;
import sample.database.Retailers;
import java.sql.Statement;
import java.time.LocalDate;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainLayout extends Application {
    private TableView tableView;
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private final ToggleButton products = new ToggleButton("Products");
    private final ToggleButton farmers = new ToggleButton("Farmers");
    private final ToggleButton retailers = new ToggleButton("Retailers");

    private void Layout(TableView tableView, GridPane bottomPane){

        //Define the main layout of the ui
        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(3);
        grid.setHgap(3);

        GridPane topPane = new GridPane();
        topPane.setVgap(3);
        topPane.setHgap(3);
        topPane.setPrefSize(12, 50);
        topPane.add(products, 0, 0);
        topPane.add(farmers, 1, 0);
        topPane.add(retailers, 2, 0);

        products.setFocusTraversable(false);
        farmers.setFocusTraversable(false);
        retailers.setFocusTraversable(false);
        tableView.setFocusTraversable(false);
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        GridPane.getHgrow(tableView);
        ColumnConstraints column1 = new ColumnConstraints(100, 200, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        RowConstraints row1 = new RowConstraints(30, 30, Double.MIN_VALUE);
        RowConstraints row2 = new RowConstraints(200, 1000, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints(30, 30, Double.MIN_VALUE);
        grid.getRowConstraints().addAll(row1, row2, row3);

        grid.add(topPane, 0, 0);
        grid.add(tableView, 0, 1, 1, 1);
        grid.add(bottomPane, 0, 2);
        Scene scene = new Scene(grid, 700, 400);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Farmers Produce Management System");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    @Override
    public void start(Stage primaryStage)  {
        Layout(Products(), ProductsPane());
        //Setting the buttons property, such as the highlight, and adding them to
        //toggle group to allow only one to be selected at a time
        products.selectedProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue){
                products.setStyle(
                        "-fx-border-color:  blue;"
                );
            }else{
                products.setStyle("-fx-focus-color: transparent");
            }
        });
        farmers.selectedProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue){
                farmers.setStyle(
                        "-fx-border-color: blue;"
                );
            }else{
                farmers.setStyle("-fx-focus-color: transparent");
            }
        });
        retailers.selectedProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue){
                retailers.setStyle(
                        "-fx-border-color: blue;"
                );
            }else{
                retailers.setStyle("-fx-focus-color: transparent");
            }
        });
        //setting listeners and the methods to call when clicked to the respective buttons
        products.setOnAction(event -> {
            closePreviousWindow();
            Layout(Products(), ProductsPane());

        });
        farmers.setOnAction(event -> {
            closePreviousWindow();
            try {
                Layout(Farmers(), FarmersPane());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        retailers.setOnAction(event -> {
            closePreviousWindow();
            Layout(Retailers(), RetailorsPane());

        });

        toggleGroup.getToggles().addAll(products, farmers, retailers);

    }

    private TableView<Products> Products() {
        //Takes table view from the table class and returns it
        try {
            ProductsTbl productsTbl = new ProductsTbl();
            tableView = productsTbl.ProductsData();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tableView;
    }

    private TableView<Farmers> Farmers() {
        //Takes table view from the table class and returns it
        try {
            FarmersTable farmersTable = new FarmersTable();
            tableView = farmersTable.FarmersData();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tableView;
    }

    private TableView<Retailers> Retailers(){
        //Takes table view from the table class and returns it
        try{
            RetailersTable retailersTable = new RetailersTable();
            tableView = retailersTable.RetailersData();
        }catch (IOException e){
            System.out.println(e);
        }
        return tableView;
    }
    private GridPane FarmersPane() throws SQLException{
        //Creates the bottom pane of farmers page and returns it
        TextField firstName = new TextField();
        firstName.promptTextProperty().setValue("First Name");
        TextField lastName = new TextField();
        lastName.promptTextProperty().setValue("Last Name");
        TextField phoneNumber= new TextField();
        phoneNumber.promptTextProperty().setValue("PhoneNumber");
        TextField productName = new TextField();
        productName.promptTextProperty().setValue("Product");
        TextField amount = new TextField();
        amount.promptTextProperty().setValue("Amount");
        TextField unit = new TextField();
        unit.promptTextProperty().setValue("Unit");
        TextField price = new TextField();
        price.promptTextProperty().setValue("Price");
        Button add = new Button("Add");
        add.setOnAction(event -> {
            try {
                String fName = firstName.getText();
                String lName = lastName.getText();
                int phoneNum = Integer.parseInt(phoneNumber.getText());
                String prodName = productName.getText();
                int amountTxt = Integer.parseInt(amount.getText());
                String unitTxt = unit.getText();
                int pPrice =  Integer.parseInt(price.getText());
                insert( prodName, amountTxt, unitTxt);
                insert("Farmers",fName, lName, phoneNum, pPrice);
                closePreviousWindow();
                Layout(Farmers(), FarmersPane());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        GridPane farmersGridPane = new GridPane();
        farmersGridPane.setVgap(3);
        farmersGridPane.setHgap(3);
        farmersGridPane.setPrefSize(12, 50);
        farmersGridPane.add(firstName, 0, 0);
        farmersGridPane.add(lastName, 1, 0);
        farmersGridPane.add(phoneNumber, 2, 0);
        farmersGridPane.add(productName, 3, 0);
        farmersGridPane.add(amount, 4, 0);
        farmersGridPane.add(unit, 5, 0);
        farmersGridPane.add(price, 6, 0);
        farmersGridPane.add(add, 8, 0);
        return farmersGridPane;
    }

    private GridPane RetailorsPane(){
        //Creates the bottom pane of retailers page and returns it

        TextField firstName = new TextField();
        firstName.promptTextProperty().setValue("First Name");
        TextField lastName = new TextField();
        lastName.promptTextProperty().setValue("Last Name");
        TextField phoneNumber= new TextField();
        phoneNumber.promptTextProperty().setValue("PhoneNumber");
        TextField productName = new TextField();
        productName.promptTextProperty().setValue("Product");
        TextField amount = new TextField();
        amount.promptTextProperty().setValue("Amount");
        TextField unit = new TextField();
        unit.promptTextProperty().setValue("Unit");
        TextField price = new TextField();
        price.promptTextProperty().setValue("Price");
        Button add = new Button("Add");
        add.setOnAction(event -> {
            try {
                String fName = firstName.getText();
                String lName = lastName.getText();
                int phoneNum = Integer.parseInt(phoneNumber.getText());
                String prodName = productName.getText();
                int amountTxt = Integer.parseInt(amount.getText());
                String unitTxt = unit.getText();
                int pPrice =  Integer.parseInt(price.getText());
                insert( prodName, amountTxt, unitTxt);
                insert("Retailers", fName, lName, phoneNum,pPrice);
                closePreviousWindow();
                Layout(Retailers(), RetailorsPane());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        GridPane retailorsGridPane = new GridPane();
        retailorsGridPane.setVgap(3);
        retailorsGridPane.setHgap(3);
        retailorsGridPane.setPrefSize(12, 50);
        retailorsGridPane.add(firstName, 0, 0);
        retailorsGridPane.add(lastName, 1, 0);
        retailorsGridPane.add(phoneNumber, 2, 0);
        retailorsGridPane.add(productName, 3, 0);
        retailorsGridPane.add(amount, 4, 0);
        retailorsGridPane.add(unit, 5, 0);
        retailorsGridPane.add(price, 6, 0);
        retailorsGridPane.add(add, 8, 0);
        return retailorsGridPane;
    }

    private GridPane ProductsPane(){
        //Creates the bottom pane of farmers page and returns it
        GridPane productsGridPane = new GridPane();
        return productsGridPane;
    }
    private void closePreviousWindow() {
        Stage stage = (Stage) products.getScene().getWindow();
        stage.close();
    }

    private void insert( String tablename, String fname, String lname, int phoneNumber , int Price) throws SQLException {
        //insert statement that inserts and saves
        // content from the user to the database,products and retailers table
        DatabaseConnection conn = new DatabaseConnection();
        Connection connection = conn.connect();
        Statement statement = null;
        statement = connection.createStatement();
        String p_id = "SELECT Id FROM Products ORDER BY Id DESC LIMIT 1";
        ResultSet resultSet = statement.executeQuery(p_id);
        int product_id = resultSet.getInt("Id");
        String SQL = "insert into " + tablename+ " ( FirstName , LastName , PhoneNumber, Price, Products_id) "
        + "values ('" +
   fname+ "','" + lname + "'," + phoneNumber +"," + Price +"," + product_id + " )";
        statement.executeUpdate(SQL);
        statement.close();
        connection.commit();
        connection.close();
    }
    private void insert(  String productname,int amount, String unit) throws SQLException {
        //inserts and saves  data to teh database from the user to the products table
        DatabaseConnection conn = new DatabaseConnection();
        Connection connection = conn.connect();
        Statement statement = null;
        String date = LocalDate.now().plusYears(1).toString();
        statement = connection.createStatement();
        String SQL = "INSERT INTO Products (Name, Amount, Unit, ExpiryDate) " +
                "VALUES ('" + productname + "',"+ amount +",'"+ unit +"','" + date + "'" +")";
        statement.executeUpdate(SQL);
        statement.close();
        connection.commit();
        connection.close();
    }

}
