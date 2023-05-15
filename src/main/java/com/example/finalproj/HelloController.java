package com.example.finalproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private Label text3;

    @FXML
    private Label text4;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

        text3.setText(text1.getText());
        text4.setText(text2.getText());
    }

}