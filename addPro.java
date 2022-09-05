package com.example.storemanagaement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class addPro {

    @FXML
private TextField Txt_name, Txt_cat, Txt_type, Txt_id, Txt_stock;


    public void AddProduct() throws SQLException {
        Txt_name.getText();
        Txt_cat.getText();
        Txt_type.getText();
        Txt_id.getText();
        Txt_stock.getText();

        if(Txt_type.getText().isBlank() || Txt_cat.getText().isBlank() || Txt_name.getText().isBlank() || Txt_id.getText().isBlank() ||Txt_stock.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all input fields ");
            alert.setTitle("EMPTY FIELDS");
            alert.showAndWait();
        } else {
            DBConector.addProducts(Txt_name.getText(), Txt_cat.getText(), Txt_stock.getText(), Txt_type.getText());
            Txt_name.clear(); Txt_cat.clear(); Txt_type.clear(); Txt_stock.clear();Txt_id.clear();
        }

    }






}
