package com.example.hoja11.Control;

import java.util.ArrayList;

public class TestPreguntas {

    private int id;
    private String nombre;
    private ArrayList<TestRespuestas> respuestas;

    public TestPreguntas(int id, String nombre, ArrayList<TestRespuestas> respuestas) {
        this.id = id;
        this.nombre = nombre;
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<TestRespuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<TestRespuestas> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "TestPreguntas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }
}