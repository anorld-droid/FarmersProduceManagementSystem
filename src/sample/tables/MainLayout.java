package sample.tables;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.database.Farmers;
import sample.database.Products;
import sample.database.Retailers;

import java.io.IOException;

public class MainLayout extends Application {
    private TableView tableView;
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private final ToggleButton products = new ToggleButton("Products");
    private final ToggleButton farmers = new ToggleButton("Farmers");
    private final ToggleButton retailers = new ToggleButton("Retailers");



    private void Layout(TableView tableView, GridPane bottomPane){


        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(3);
        grid.setHgap(3);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(3);
        gridPane.setHgap(3);
        gridPane.setPrefSize(12, 50);
        gridPane.add(products, 0, 0);
        gridPane.add(farmers, 1, 0);
        gridPane.add(retailers, 2, 0);

        products.setFocusTraversable(false);
        farmers.setFocusTraversable(false);
        retailers.setFocusTraversable(false);
        tableView.setFocusTraversable(false);
        GridPane.getHgrow(tableView);
        ColumnConstraints column1 = new ColumnConstraints(100, 200, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        RowConstraints row1 = new RowConstraints(30, 30, Double.MIN_VALUE);
        RowConstraints row2 = new RowConstraints(200, 1000, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints(30, 30, Double.MIN_VALUE);
        grid.getRowConstraints().addAll(row1, row2, row3);

        grid.add(gridPane, 0, 0);
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
    public void start(Stage primaryStage) throws Exception {

        Layout(Products(), ProductsPane());
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
        products.setOnAction(event -> {
            closePreviousWindow();
            Layout(Products(), ProductsPane());

        });
        farmers.setOnAction(event -> {
            closePreviousWindow();
            Layout(Farmers(), FarmersPane());

        });
        retailers.setOnAction(event -> {
            closePreviousWindow();
            Layout(Retailers(), RetailorsPane());

        });

        toggleGroup.getToggles().addAll(products, farmers, retailers);

    }

    private TableView<Products> Products() {
        try {
            ProductsTbl productsTbl = new ProductsTbl();
            tableView = productsTbl.Products();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tableView;
    }

    private TableView<Farmers> Farmers() {
        try {
            FarmersTable farmersTable = new FarmersTable();
            tableView = farmersTable.Farmers();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tableView;
    }

    private TableView<Retailers> Retailers(){
        try{
            RetailersTable retailersTable = new RetailersTable();
            tableView = retailersTable.Retailers();
        }catch (IOException e){
            System.out.println(e);
        }
        return tableView;
    }
    private GridPane FarmersPane(){
        TextField firstName = new TextField();
        firstName.promptTextProperty().setValue("First Name");
        TextField lastName = new TextField();
        lastName.promptTextProperty().setValue("Last Name");
        TextField productName = new TextField();
        productName.promptTextProperty().setValue("Product");
        TextField first_name = new TextField();
        first_name.promptTextProperty().setValue("First Name");
        TextField quantity = new TextField();
        quantity.promptTextProperty().setValue("Quantity");
        TextField expiryDate = new TextField();
        expiryDate.promptTextProperty().setValue("Expiry Date");
        Button add = new Button("Add");

        GridPane farmersGridPane = new GridPane();
        farmersGridPane.setVgap(3);
        farmersGridPane.setHgap(3);
        farmersGridPane.setPrefSize(12, 50);
        farmersGridPane.add(firstName, 0, 0);
        farmersGridPane.add(lastName, 1, 0);
        farmersGridPane.add(productName, 2, 0);
        farmersGridPane.add(quantity, 3, 0);
        farmersGridPane.add(expiryDate, 4, 0);
        farmersGridPane.add(add, 5, 0);
        return farmersGridPane;
    }

    private GridPane RetailorsPane(){
        TextField firstName = new TextField();
        firstName.promptTextProperty().setValue("First Name");
        TextField lastName = new TextField();
        lastName.promptTextProperty().setValue("Last Name");
        TextField productName = new TextField();
        productName.promptTextProperty().setValue("Product");
        TextField first_name = new TextField();
        first_name.promptTextProperty().setValue("First Name");
        TextField quantity = new TextField();
        quantity.promptTextProperty().setValue("Quantity");
        Button add = new Button("Add");

        GridPane retailorsGridPane = new GridPane();
        retailorsGridPane.setVgap(3);
        retailorsGridPane.setHgap(3);
        retailorsGridPane.setPrefSize(12, 50);
        retailorsGridPane.add(firstName, 0, 0);
        retailorsGridPane.add(lastName, 1, 0);
        retailorsGridPane.add(productName, 2, 0);
        retailorsGridPane.add(quantity, 3, 0);
        retailorsGridPane.add(add, 5, 0);
        return retailorsGridPane;
    }

    private GridPane ProductsPane(){
        GridPane productsGridPane = new GridPane();
        return productsGridPane;
    }
    private void closePreviousWindow() {
        Stage stage = (Stage) products.getScene().getWindow();
        stage.close();
    }

}
