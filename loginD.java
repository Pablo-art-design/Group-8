package com.example.storemanagaement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginD {

    public TextField Txt_user;
    public TextField Txt_pass;

    public Button Butt_log;


    public String txt_1;
    public String txt_2;

    public void Showform() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 629, 467);
        Stage stage = new Stage();
        stage.setTitle("register");
        stage.setScene(scene);
        stage.show();


    }

    public void  deLog() {
        try {
            txt_1 = Txt_user.getText();
            txt_2 = Txt_pass.getText();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (txt_1.isBlank()|| txt_2.isBlank()){

                alert.setHeaderText(" Password or username field empty");
                alert.showAndWait();
            }else {
                DBConector.Logincheck(txt_1, txt_2);
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }










}
