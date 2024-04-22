package com.mdz.application.hotel.models;

public class Habitaciones {
    protected int capacidadPersonas;
    protected int numeroHabitacion;
    protected double precio;
    protected boolean status;

    public Habitaciones(int capacidadPersonas, int numeroHabitacion, double precio, boolean status) {
        this.capacidadPersonas = capacidadPersonas;
        this.numeroHabitacion = numeroHabitacion;
        this.precio = precio;
        this.status = status;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Habitaciones" +
                "Capacida:" + capacidadPersonas +  '\n' +
                "Numero de habitacion: " + numeroHabitacion + '\n' +
                "Precio: " + precio + '\n' ;
    }
}
