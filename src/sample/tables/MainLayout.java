package sample.tables;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.database.Farmers;

public class MainLayout extends Application {
    private TableView tableView;
//    public MainLayout(TableView tableView){
//        this.tableView = tableView;
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Products
        ProductsTbl productsTbl = new ProductsTbl();
        FarmersTable farmersTable = new FarmersTable();
        RetailersTable retailersTable = new RetailersTable();
        tableView = retailersTable.Retailers();
        Button products = new Button("Products");
        Button farmers = new Button("Farmers");
        Button retailers = new Button("Retailers");
        //Farmers
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


        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(3);
        grid.setHgap(3);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(3);
        gridPane.setHgap(3);
        gridPane.setPrefSize(12,50);
        gridPane.add(products, 0,0);
        gridPane.add(farmers,1,0);
        gridPane.add(retailers,2,0);

        GridPane farmersGridPane = new GridPane();
        farmersGridPane.setVgap(3);
        farmersGridPane.setHgap(3);
        farmersGridPane.setPrefSize(12,50);
        farmersGridPane.add(firstName, 0,0);
        farmersGridPane.add(lastName,1,0);
        farmersGridPane.add(productName,2,0);
        farmersGridPane.add(quantity,3,0);
        farmersGridPane.add(expiryDate,4,0);
        farmersGridPane.add(add, 5,0);

        GridPane.getHgrow(tableView);
        ColumnConstraints column1 = new ColumnConstraints(100,200,Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        RowConstraints row1 = new RowConstraints(30,30, Double.MIN_VALUE);
        RowConstraints row2 = new RowConstraints(200,1000,Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints(30,30, Double.MIN_VALUE);
        grid.getRowConstraints().addAll(row1, row2, row3);

        grid.add(gridPane, 0, 0);
        grid.add(tableView, 0, 1, 1,1);
        grid.add(farmersGridPane,0,2);
        Scene scene = new Scene(grid,700,400);

        primaryStage.setTitle("Farmers Produce Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
