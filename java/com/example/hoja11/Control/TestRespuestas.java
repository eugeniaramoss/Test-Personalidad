package com.example.hoja11.Control;

public class TestRespuestas {

    private int id;
    private int id_pregunta;
    private String nombre;
    private int puntuacion;

    public TestRespuestas(int id, int id_pregunta, String nombre, int puntuacion) {
        this.id = id;
        this.id_pregunta = id_pregunta;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "TestRespuestas{" +
                "id=" + id +
                ", id_pregunta=" + id_pregunta +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}