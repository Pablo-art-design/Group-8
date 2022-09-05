package com.example.storemanagaement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class customercontroller {

    @FXML
    private TextField Txt_name, Txt_producttype, Txt_amoun, Txt_contact;

    @FXML
    private Button Txt_add;

    public void deCustom() throws SQLException {

        Txt_name.getText();
        Txt_contact.getText();
        Txt_producttype.getText();
        Txt_amoun.getText();

        try {

            if (Txt_name.getText().isBlank()  || Txt_contact.getText().isBlank() || Txt_producttype.getText().isBlank() || Txt_amoun.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all input fields ");
                alert.setTitle("EMPTY FIELDS");
                alert.showAndWait();
            } else {
                DBConector. deCustom(Txt_name.getText(), Integer.parseInt(Txt_contact.getText()),Txt_producttype.getText(), Double.parseDouble(Txt_amoun.getText()));

                Txt_name.clear();
                Txt_contact.clear();
                Txt_producttype.clear();
                Txt_amoun.clear();


            }


        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wrong information entered ");
            alert.setHeaderText("Enter correct information");
            alert.showAndWait();
        }

        }



    }
