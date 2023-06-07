package com.example.hoja11;

import com.example.hoja11.Control.TestPreguntas;
import com.example.hoja11.Control.TestRespuestas;
import com.example.hoja11.Datos.BaseDatos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button buttonAnterior;

    @FXML
    private Button buttonSiguiente;

    @FXML
    private Label labelPregunta;

    @FXML
    private RadioButton radioRespuesta1;

    @FXML
    private RadioButton radioRespuesta2;

    @FXML
    private RadioButton radioRespuesta3;

    @FXML
    private RadioButton radioRespuesta4;

    private ArrayList<TestPreguntas> preguntas;

    private int indicePreguntaActual;
    @FXML
    private ToggleGroup grupoRespuestas;

    private int puntuacionTotal;

    private ArrayList<Integer> respuestasSeleccionadas = new ArrayList<Integer>();


    @FXML
    public void initialize() {
        grupoRespuestas = new ToggleGroup();
        radioRespuesta1.setToggleGroup(grupoRespuestas);
        radioRespuesta2.setToggleGroup(grupoRespuestas);
        radioRespuesta3.setToggleGroup(grupoRespuestas);
        radioRespuesta4.setToggleGroup(grupoRespuestas);

        BaseDatos baseDatos = new BaseDatos();
        preguntas = baseDatos.obtenerPreguntasYRespuestasAleatorias();
        indicePreguntaActual = 0;
        puntuacionTotal = 0;

        mostrarPreguntaActual();
    }

    @FXML
    void botonSiguiente(ActionEvent event) throws IOException {

        int puntuacionPregunta;

        for (int i = 0; i < preguntas.size(); i++) {
            if (indicePreguntaActual < preguntas.size() - 1) {
                if (validarRespuestaSeleccionada()) {
                    puntuacionPregunta = preguntas.get(indicePreguntaActual).getRespuestas().get(i).getPuntuacion();
                    puntuacionTotal += puntuacionPregunta;
                    System.out.println(puntuacionTotal);
                    indicePreguntaActual++;
                    mostrarPreguntaActual();
                }
            } else if (validarRespuestaSeleccionada()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaResultados.fxml"));
                Pane pane = loader.load();

                Scene scene = new Scene(pane);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        }

    }

    private boolean validarRespuestaSeleccionada() {
        RadioButton respuestaSeleccionada = (RadioButton) grupoRespuestas.getSelectedToggle();
        return respuestaSeleccionada != null;
    }

    @FXML
    void botonAnterior(ActionEvent event) {
        if (indicePreguntaActual > 0) {
            indicePreguntaActual--;
            mostrarPreguntaActual();
        }
    }

    private void mostrarPreguntaActual() {
        TestPreguntas pregunta = preguntas.get(indicePreguntaActual);
        labelPregunta.setText(pregunta.getNombre());

        ArrayList<TestRespuestas> respuestas = pregunta.getRespuestas();
        radioRespuesta1.setText(respuestas.get(0).getNombre());
        radioRespuesta1.setUserData(1);
        radioRespuesta1.setToggleGroup(grupoRespuestas);

        radioRespuesta2.setText(respuestas.get(1).getNombre());
        radioRespuesta2.setUserData(2);
        radioRespuesta2.setToggleGroup(grupoRespuestas);

        radioRespuesta3.setText(respuestas.get(2).getNombre());
        radioRespuesta3.setUserData(3);
        radioRespuesta3.setToggleGroup(grupoRespuestas);

        radioRespuesta4.setText(respuestas.get(3).getNombre());
        radioRespuesta4.setUserData(4);
        radioRespuesta4.setToggleGroup(grupoRespuestas);

        grupoRespuestas.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {

            if (grupoRespuestas.getSelectedToggle() != null) {
                int puntos =  (int)grupoRespuestas.getSelectedToggle().getUserData();
                respuestasSeleccionadas.add(puntos);
            }
        });

        grupoRespuestas.selectToggle(null);
    }

    public int sumarPuntos(){
        int total = 0;
        for (Integer respuestas:respuestasSeleccionadas) {
            total+=respuestas;
        }
        return total;
    }

    public String mostrarResultado() {
        String texto = "";
        if (sumarPuntos() >= 10 && sumarPuntos() <= 18) {
            texto = "Loro y Periodista: Los loros son conocidos por su capacidad de imitar y repetir palabras. Como periodista, un loro podría utilizar su habilidad para entrevistar a diversas personas, informar sobre noticias importantes y transmitir información de manera precisa.";
        } else if (sumarPuntos() >= 19 && sumarPuntos() <= 26) {
            texto = "Elefante y Escritor/a de Libros Infantiles: Los elefantes son considerados animales inteligentes y tienen una gran memoria. Como escritor/a de libros infantiles, un elefante podría utilizar su sabiduría y creatividad para escribir historias encantadoras que enseñen valiosas lecciones a los niños.";
        } else if (sumarPuntos() >= 27 && sumarPuntos() <= 34) {
            texto = "Búho y Poeta: Los búhos son conocidos como símbolos de sabiduría y observación. Como poeta, un búho podría utilizar su agudeza mental y su habilidad para apreciar la belleza en la oscuridad para componer versos profundos y evocadores.";
        } else if (sumarPuntos() >= 35 && sumarPuntos() <= 40) {
            texto = "Zorro y Guionista: Los zorros son animales astutos y sigilosos. Como guionista, un zorro podría utilizar su astucia para crear tramas intrigantes, diálogos ingeniosos y sorpresas inesperadas en la escritura de guiones para películas o series de televisión.";
        }
        System.out.println(sumarPuntos());
        return texto;
    }
}