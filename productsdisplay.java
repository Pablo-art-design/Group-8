package com.example.storemanagaement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.*;

public class productsdisplay {

    @FXML
    public TextField Txt_name, Txt_products, Txt_category, Txt_type, Txt_id;

    @FXML
    private Button  butt_search;




    public void SearchButton () throws SQLException {
        Connection connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
        PreparedStatement search = null;
        ResultSet resultSet = null;
             Alert alert = new Alert(Alert.AlertType.ERROR);
        try {
                String proId = Txt_id.getText();
                if (proId.isBlank()) {
                    alert.setHeaderText("Product search field cannot be empty.");
                    alert.showAndWait();
                }else {
//                    DBConector.SearchProducts(Integer.parseInt(proId));
                    String query = "Select * From products Where id = ?";
                    search = connect.prepareStatement(query);
                    search.setInt(1, Integer.parseInt(proId));
                    resultSet = search.executeQuery();
                    if (resultSet.next()){
                        String name = resultSet.getString("name");
                        String category = resultSet.getString("category");
                        int products = resultSet.getInt("product_in_stock");
                        String type = resultSet.getString("product_type");

                        Txt_name.setText(name);
                        Txt_category.setText(category);
                        Txt_products.setText(String.valueOf(products));
                        Txt_type.setText(type);
                    }else {
                        alert.setHeaderText(" Search not Found ");
                        alert.showAndWait();
                    }
                }
            }catch (NumberFormatException e){
            alert.setHeaderText(" Invalid Search Input ");
            alert.showAndWait();
        }catch (NullPointerException e){
            e.printStackTrace();
            alert.setHeaderText(" Search Field Cannot Be Empty");
            alert.showAndWait();
        }

    }

    public void ClearBtn() {
        Txt_products.clear();
        Txt_category.clear();
        Txt_name.clear();
        Txt_id.clear();
        Txt_type.clear();
    }










}