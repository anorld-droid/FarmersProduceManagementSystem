package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.tables.MainLayout;

import java.io.IOException;

public class Controller {
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public Button loginBtn;
    @FXML
    public Label lblStatus;
    @FXML
    public Button productsBtn;
    @FXML
    public Button farmersBtn;
    @FXML
    public Button retailersBtn;
    @FXML
    public TableView farmersTbl;
    @FXML
    public TableView retailerTbl;
    @FXML
    public TableView productTbl;
    @FXML
    public TableColumn expiryDate;
    @FXML
    public TableColumn quantity;
    @FXML
    public TableColumn name;
    @FXML
    public TableColumn id;


    public void Login(ActionEvent actionEvent) throws Exception {
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Log in Successful");
            MainLayout mainLayout = new MainLayout();
            Stage stage = new Stage();
            mainLayout.start(stage);
            closeLoginAction();
        } else {
            lblStatus.setText("Incorrect password or username.");
        }
    }

    @FXML
    public void closeLoginAction() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.close();
    }


}