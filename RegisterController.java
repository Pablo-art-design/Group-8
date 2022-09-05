package com.example.storemanagaement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField txt_password;
    @FXML
    public Button txt_submit;

    public void dashboard() throws IOException {
        FXMLLoader homepage = new FXMLLoader(StartApp.class.getResource("view.fxml"));
        Scene scene = new Scene(homepage.load(),700, 470 );
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("DASHBOARD");
        stage.show();
    }

    public void showDashboard() throws IOException {
        dashboard();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txt_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(txt_fullname.getText().isBlank() || txt_email.getText().isBlank() || txt_username.getText().isBlank()){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Fill in empty spaces");
                        alert.setTitle("Empty spaces");
                        alert.showAndWait();
                    } else {
                        DBConector.RegisterUser(event, txt_fullname.getText(), txt_username.getText(), txt_email.getText(), txt_password.getText());
                        txt_fullname.clear();
                        txt_email.clear();
                        txt_username.clear();
                        txt_password.clear();
                        txt_submit.getScene().getWindow().hide();


//                        hide.hide();
//                        Stage hide = (Stage)this.txt_submit.getScene().getWindow();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}