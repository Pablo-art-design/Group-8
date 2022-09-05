package com.example.storemanagaement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBConector {
    public static void RegisterUser(ActionEvent event, String fullName, String username, String email, String passsword) {
        Connection connect = null;
        PreparedStatement insert = null;
        PreparedStatement userExist = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

            userExist = connect.prepareStatement("SELECT * FROM register WHERE username = ?");
            userExist.setString(1, username);
            resultSet = userExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Already Exist");
                alert.show();
            } else {
                String sql = "INSERT INTO register(fullName, username, email, passsword) VALUES (?,?,?,?)";
                insert = connect.prepareStatement(sql);
                insert.setString(1, fullName);
                insert.setString(2, username);
                insert.setString(3, email);
                insert.setString(4, passsword);

                int row = insert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("New User Registered");
                    alert.showAndWait();

                }
            }
            resultSet = userExist.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addProducts(String name, String category, String stock, String type) throws SQLException {
        Connection connect = null;
        PreparedStatement insert = null;
        ResultSet result = null;
        int count = 0;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

            String query = "INSERT INTO products(name, category, product_in_stock, product_type) VALUES(?, ?, ?, ?)";
            insert = connect.prepareStatement(query);

            insert.setString(1, name);
            insert.setString(2, category);
            insert.setString(3, stock);
            insert.setString(4, type);
            count = insert.executeUpdate();

            Alert alert;
            if (count > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION, "Product Insert Successfully");
                alert.setTitle("SUCCESS");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR, "Unable to add product");
                alert.setTitle("FAILED");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void paymentwer(String method, Date date, Double amount) throws SQLException {
        Connection connect = null;
        PreparedStatement insert = null;
        ResultSet result = null;
        int count = 0;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

            String query = "INSERT INTO payment(payment_method, date, amount) VALUES(?, ?, ?)";
            insert = connect.prepareStatement(query);

            insert.setString(1, method);
            insert.setDate(2, date);
            insert.setDouble(3, amount);

            count = insert.executeUpdate();

            Alert alert;
            if (count > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION, "Payment Successfull");
                alert.setTitle("SUCCESS");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR, "Wrong transaction");
                alert.setTitle("FAILED");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please input date format like ");
            alert.setHeaderText("eg yyy-mm-dd");
            alert.showAndWait();
        }
    }


    public static void ordered(Double price, int quantity, Double discount, String name) throws SQLException {
        Connection connect = null;
        PreparedStatement insert = null;
        ResultSet result = null;
        int count = 0;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

            String query = "INSERT INTO order_details(price, quantity,discount, name) VALUES(?, ?, ?, ? )";
            insert = connect.prepareStatement(query);

            insert.setDouble(1, price);
            insert.setInt(2, quantity);
            insert.setDouble(3, discount);
            insert.setString(4, name);

            count = insert.executeUpdate();

            Alert alert;
            if (count > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION, "Product Ordered Successfully");
                alert.setTitle("SUCCESS");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR, "Unable to Order product");
                alert.setTitle("FAILED");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public static void deCustom(String name, int contact, String producttype, Double amoun) throws SQLException {
        Connection connect = null;
        PreparedStatement insert = null;
        ResultSet result = null;
        int count = 0;


        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

            String query = "INSERT INTO customer (name, contact,product_type, amoun ) VALUES(?, ?, ?, ? )";
            insert = connect.prepareStatement(query);

            insert.setString(1, name);
            insert.setInt(2, contact);
            insert.setString(3, producttype);
            insert.setDouble(4, amoun);
            count = insert.executeUpdate();

            Alert alert;
            if (count > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION, "Customer added");
                alert.setTitle("SUCCESS");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR, "Customer rejected");
                alert.setTitle("FAILED");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public static void Logincheck (String username, String password) {
        Connection connect = null;
        PreparedStatement log = null;
        ResultSet rest = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
            String query = "Select username, passsword From register where username = ? and passsword = ? ";
            log = connect.prepareStatement(query);
            log.setString(1,  username);
            log.setString(2,  password);
            rest = log.executeQuery();

            if (rest.next()){
                FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("Dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 828, 518);
                Stage stage = new Stage();
                stage.setTitle("Products Form");
                stage.setScene(scene);
                stage.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(" Wrong Username or password Please SignUp");
                alert.showAndWait();
            }

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void SearchProducts(int id) throws SQLException {
        PreparedStatement search = null;
        ResultSet resultSet = null;
        Connection connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");

        Alert alert = new Alert(Alert.AlertType.ERROR);
        try {
            String query = "Select * From products Where id = ?";
            search = connect.prepareStatement(query);
            search.setInt(1, id );
            resultSet = search.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int products = resultSet.getInt("product_in_stock");
                String type = resultSet.getString("product_type");

                productsdisplay display = new productsdisplay();
                display.Txt_name.setText(name);
                display.Txt_category.setText(category);
                display.Txt_products.setText(String.valueOf(products));
                display.Txt_type.setText(type);
            }else {

                alert.setHeaderText(" Search not Found ");
                alert.showAndWait();

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (NumberFormatException e){
            alert.setHeaderText(" Invalid Search Input ");
            alert.showAndWait();

        }catch (NullPointerException e)
        {
            e.printStackTrace();
            alert.setHeaderText(" Search Field Cannot Be Empty");
            alert.showAndWait();
        }
    }



}