package com.example.storemanagaement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class dashBoard {

    @FXML
       private BorderPane displayScene;
        Pane pane;

        public BorderPane changeScene(String nameOfFile) throws IOException {
            FXMLLoader load = new FXMLLoader(StartApp.class.getResource(nameOfFile));
        displayScene.setCenter(load.load());
            return displayScene;
        }

    public void pro() throws IOException {
        changeScene("view.fxml");
    }

    public  void custom() throws IOException {
        changeScene("customerTable.fxml");
    }
    public void orded() throws IOException {
        changeScene("orderp.fxml");
    }
    public void payer() throws IOException {
        changeScene("Payment.fxml");
    }
    public void searchProduct() throws IOException {
        changeScene("searchProducts.fxml");
    }
    @FXML
    Button Butt_logout;

    public void logged() throws IOException {
        Stage stage =(Stage) Butt_logout.getScene().getWindow();
        stage.close();
    }
}