package com.example.hoja11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class VistaResultado {

    @FXML
    private Text respuesta;

    @FXML
    private Text texto;

    @FXML
    private Button verResult;

    HelloController helloController = new HelloController();

    @FXML
    void resultado(ActionEvent event) {
        respuesta.setText(helloController.mostrarResultado());
    }
}