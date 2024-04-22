package com.mdz.application.hotel.models;

public class HabitacionDoble extends Habitaciones {

    private String camasSeparadas;

    public HabitacionDoble(int capacidadPersonas, int numeroHabitacion, double precio, boolean status, String camasSeparadas) {
        super(capacidadPersonas, numeroHabitacion, precio, status);
        this.camasSeparadas = camasSeparadas;
    }

    public String getCamasSeparadas() {
        return camasSeparadas;
    }

    @Override
    public String toString() {
        return "HabitacionDoble{" +
                "camasSeparadas='" + camasSeparadas + '\'' +
                ", capacidadPersonas=" + capacidadPersonas +
                ", numeroHabitacion=" + numeroHabitacion +
                ", precio=" + precio +
                ", status=" + status +
                '}';
    }
}
