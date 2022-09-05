package com.example.storemanagaement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class PaymentMethod {

    @FXML
    private TextField Txt_method, Txt_date, Txt_amount;
    @FXML
    private Button Txt_butt;


    public void paymentwer() throws SQLException {
        try {
            Txt_amount.getText();
            Txt_method.getText();
            Txt_date.getText();

            if(Txt_amount.getText().isBlank() || Txt_method.getText().isBlank() || Txt_date.getText().isBlank() ) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all input fields ");
                alert.setTitle("EMPTY FIELDS");
                alert.showAndWait();
            } else {
                DBConector.paymentwer(Txt_method.getText(), Date.valueOf(Txt_date.getText()), Double.parseDouble(Txt_amount.getText()));
                Txt_amount.clear(); Txt_method.clear(); Txt_date.clear();
            }
        } catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please input date format like ");
            alert.setHeaderText("eg yyy-mm-dd");
            alert.showAndWait();
        }
    }












}
