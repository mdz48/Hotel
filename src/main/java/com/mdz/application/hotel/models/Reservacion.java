package com.mdz.application.hotel.models;

import java.time.LocalDate;

public class Reservacion {
    private LocalDate fecha;
    private String id;
    private int habitacion;
    private int numPersonas;

    public Reservacion(LocalDate fecha, String id, int habitacion, int numPersonas) {
        this.fecha = fecha;
        this.id = id;
        this.habitacion = habitacion;
        this.numPersonas = numPersonas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "fecha=" + fecha +
                ", id='" + id + '\'' +
                ", habitacion=" + habitacion +
                ", numPersonas=" + numPersonas +
                '}';
    }
}

