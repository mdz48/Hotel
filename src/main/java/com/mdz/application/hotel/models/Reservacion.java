package com.mdz.application.hotel.models;

import java.time.LocalDate;

public class Reservacion {
    private LocalDate fecha;
    private String id;
    private int habitacion;

    public Reservacion(LocalDate fecha, String id, int habitacion) {
        this.fecha = fecha;
        this.id = id;
        this.habitacion = habitacion;
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

    @Override
    public String toString() {
        return "Reservacion{" +
                "fecha=" + fecha + '\n' +
                ", id='" + id + '\n' +
                ", habitacion=" + habitacion + '\n' +
                '}';
    }
}

