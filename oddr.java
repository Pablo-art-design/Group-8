package com.example.storemanagaement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class oddr {


    @FXML
    private TextField Txt_quantity, Txt_name, Txt_price, Txt_discount;

    @FXML
    private Button Txt_add;


    public void Ordered() throws SQLException {

        Txt_quantity.getText();
        Txt_name.getText();
        Txt_price.getText();

        Txt_discount.getText();


        if(Txt_quantity.getText().isBlank() || Txt_name.getText().isBlank() || Txt_price.getText().isBlank() ||  Txt_discount.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all input fields ");
            alert.setTitle("EMPTY FIELDS");
            alert.showAndWait();
        } else {
            DBConector.ordered(Double.parseDouble(Txt_price.getText()), Integer.parseInt(Txt_quantity.getText()), Double.parseDouble(Txt_discount.getText()),Txt_name.getText());
             Txt_quantity.clear(); Txt_price.clear(); Txt_name.clear(); Txt_discount.clear();




    }


}}