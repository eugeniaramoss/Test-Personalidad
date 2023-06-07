package com.example.hoja11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("vistaBienvenida.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test de Personalidad");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}