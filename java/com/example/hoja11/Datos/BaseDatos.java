package com.example.hoja11.Datos;

import com.example.hoja11.Control.TestPreguntas;
import com.example.hoja11.Control.TestRespuestas;

import java.sql.*;
import java.util.ArrayList;

public class BaseDatos {

    private ArrayList<TestPreguntas> preguntasYRespuestas;

    public ArrayList<TestPreguntas> obtenerPreguntasYRespuestasAleatorias() {

        preguntasYRespuestas = new ArrayList<>();

        String consultaSQL = "SELECT * FROM preguntas ORDER BY RAND() LIMIT 10";

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdHoja11", "root", "");
            Statement sentenciaSQL = conexion.createStatement();
            ResultSet resultado = sentenciaSQL.executeQuery(consultaSQL);

            while (resultado.next()) {

                int idPregunta = resultado.getInt("id");
                String nombrePregunta = resultado.getString("nombre");

                ArrayList<TestRespuestas> respuestas = obtenerRespuestasPorPregunta(idPregunta);
                TestPreguntas pregunta = new TestPreguntas(idPregunta, nombrePregunta, respuestas);

                preguntasYRespuestas.add(pregunta);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntasYRespuestas;
    }

    private ArrayList<TestRespuestas> obtenerRespuestasPorPregunta(int idPregunta) {

        ArrayList<TestRespuestas> respuestas = new ArrayList<>();

        String consultaSQL = "SELECT * FROM respuestas WHERE id_pregunta = " + idPregunta;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdHoja11", "root", "");
            Statement sentenciaSQL = conexion.createStatement();
            ResultSet resultado = sentenciaSQL.executeQuery(consultaSQL);

            while (resultado.next()) {

                int idRespuesta = resultado.getInt("id");
                String nombreRespuesta = resultado.getString("nombre");
                int puntuacionRespuesta = resultado.getInt("puntuacion");

                TestRespuestas respuesta = new TestRespuestas(idRespuesta, idPregunta, nombreRespuesta, puntuacionRespuesta);
                respuestas.add(respuesta);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return respuestas;
    }
}