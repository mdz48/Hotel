package com.mdz.application.hotel.models;

public class HabitacionSuite extends Habitaciones {
    private int numSalas;
    private int sanitarios;

    public HabitacionSuite(int capacidadPersonas, int numeroHabitacion, boolean status, double precio, int numSalas, int sanitarios) {
        super(capacidadPersonas, numeroHabitacion, precio, status);
        this.numSalas = numSalas;
        this.sanitarios = sanitarios;
        this.status = status;
    }

    public int getNumSalas() {
        return numSalas;
    }

    public int getSanitarios() {
        return sanitarios;
    }

    @Override
    public String toString() {
        return "HabitacionSuite{" +
                "numSalas=" + numSalas +
                ", sanitarios=" + sanitarios +
                ", capacidadPersonas=" + capacidadPersonas +
                ", numeroHabitacion=" + numeroHabitacion +
                ", precio=" + precio +
                ", status=" + status +
                '}';
    }
}
