package sample.tables;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainLayout extends Application {
    private TableView tableView;
//    public MainLayout(TableView tableView){
//        this.tableView = tableView;
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ProductsTbl productsTbl = new ProductsTbl();
        tableView = productsTbl.Products();
        Button products = new Button("Products");
        Button farmers = new Button("Farmers");
        Button retailers = new Button("Retailers");


        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(3);
        grid.setHgap(3);

        GridPane gridPane = new GridPane();
//       gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(3);
        gridPane.setHgap(3);
        gridPane.setPrefSize(12,50);
        gridPane.add(products, 0,0);
        gridPane.add(farmers,1,0);
        gridPane.add(retailers,2,0);
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setButtonData(products, ButtonBar.ButtonData.APPLY);
        buttonBar.setButtonData(farmers, ButtonBar.ButtonData.APPLY);
        buttonBar.setButtonData(retailers, ButtonBar.ButtonData.APPLY);
        buttonBar.getButtons().addAll(products, farmers, retailers);
//

        GridPane.getHgrow(tableView);
        ColumnConstraints column1 = new ColumnConstraints(100,200,Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        RowConstraints row1 = new RowConstraints(30,30, Double.MIN_VALUE);
        RowConstraints row2 = new RowConstraints(200,1000,Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        grid.getRowConstraints().addAll(row1, row2);
        grid.add(gridPane, 0, 0);
        grid.add(tableView, 0, 1, 1,1);

        Scene scene = new Scene(grid,700,400);

        primaryStage.setTitle("FPMS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
