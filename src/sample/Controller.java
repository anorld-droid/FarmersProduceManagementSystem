package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.tables.MainLayout;


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
    public TableColumn id;


    public void Login(ActionEvent actionEvent) throws Exception {
        //checks if the password is correct then calls the mainlayout
        //if it's correct and closes
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