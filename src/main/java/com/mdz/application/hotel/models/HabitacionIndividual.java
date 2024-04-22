package com.mdz.application.hotel.models;

public class HabitacionIndividual extends Habitaciones{
    private String tipoCama;

    public HabitacionIndividual(int capacidadPersonas, int numeroHabitacion, double precio, boolean status,  String tipoCama) {
        super(capacidadPersonas, numeroHabitacion, precio, status);
        this.tipoCama = tipoCama;
    }


    public String getTipoCama() {
        return tipoCama;
    }

    @Override
    public String toString() {
        return "HabitacionIndividual{" +
                "tipoCama='" + tipoCama + '\'' +
                ", capacidadPersonas=" + capacidadPersonas +
                ", numeroHabitacion=" + numeroHabitacion +
                ", precio=" + precio +
                ", status=" + status +
                '}';
    }
}
