package com.mdz.application.hotel.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private ArrayList<HabitacionIndividual> individuales = new ArrayList<>();
    private ArrayList<HabitacionDoble> habitacionDobles = new ArrayList<>();
    private ArrayList<HabitacionSuite> suites = new ArrayList<>();
    private ArrayList<Reservacion> reservaciones = new ArrayList<>();

    public ArrayList<HabitacionIndividual> getIndividuales() {
        return individuales;
    }

    public ArrayList<HabitacionDoble> getHabitacionDobles() {
        return habitacionDobles;
    }

    public ArrayList<HabitacionSuite> getSuites() {
        return suites;
    }

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void sethabitaciones() {
        individuales.add(new HabitacionIndividual(1, 101, 100, true , "cama sencilla"));
        individuales.add(new HabitacionIndividual(1, 104, 100, true ,"cama sencilla"));
        individuales.add(new HabitacionIndividual(1, 110, 100, true ,"cama sencilla"));
        habitacionDobles.add(new HabitacionDoble(3, 202, 150, true ,"Separadas"));
        habitacionDobles.add(new HabitacionDoble(3, 220, 150,true ,"Unidsa"));
        habitacionDobles.add(new HabitacionDoble(3, 250, 150,true ,"Separadas"));
        suites.add(new HabitacionSuite(6, 404, true ,300, 5,  2));
        suites.add(new HabitacionSuite(6, 401, true ,300, 2,  2));
        suites.add(new HabitacionSuite(6, 408, true ,300, 4,2));
    }



    public boolean reservarIndividual(int num, LocalDate fecha, int personas){
        boolean flag = false;
        for (int i = 0; i < individuales.size(); i++) {
            if (num == individuales.get(i).getNumeroHabitacion() && individuales.get(i).isStatus() == true) {
                Reservacion reservacion = new Reservacion(fecha, UUID.randomUUID().toString(), num, personas);
                reservaciones.add(reservacion);
                individuales.get(i).setStatus(false);
                flag = true;
                i = individuales.size();
            }
        }
        return flag;
    }

    public boolean resevarDoble(int num, LocalDate fecha, int personas){
        boolean flag = false;
        for (int i = 0; i < habitacionDobles.size(); i++) {
            if (num == habitacionDobles.get(i).getNumeroHabitacion() && habitacionDobles.get(i).isStatus() == true) {
                flag = true;
                habitacionDobles.get(i).setStatus(false);
                Reservacion reservacion = new Reservacion(fecha, UUID.randomUUID().toString(), num, personas);
                reservaciones.add(reservacion);
                i = habitacionDobles.size();
            }
        }
        return flag;
    }

    public boolean reservarSuite(int num, LocalDate fecha, int personas){
        boolean flag = false;
        for (int i = 0; i < suites.size(); i++) {
            if (num == suites.get(i).getNumeroHabitacion() && suites.get(i).isStatus() == true) {
                flag = true;
                Reservacion reservacion = new Reservacion(fecha, UUID.randomUUID().toString(), num, personas);
                reservaciones.add(reservacion);
                suites.get(i).setStatus(false);
                i = suites.size();
            }
        }
        return flag;
    }

    public ArrayList<Habitaciones> verDisponibles(){
        ArrayList<Habitaciones> aux = new ArrayList<>();
        for (int i = 0; i < individuales.size(); i++) {
            if (individuales.get(i).isStatus() == true) {
                aux.add(individuales.get(i));
            }
        }
        for (int i = 0; i < individuales.size(); i++) {
            if (habitacionDobles.get(i).isStatus() == true) {
                aux.add(habitacionDobles.get(i));
            }
        }
        for (int i = 0; i < suites.size(); i++) {
            if (suites.get(i).isStatus() == true) {
                aux.add(suites.get(i));
            }
        }
        return aux;
    }

    public boolean cancelarReservacion(String id){
        boolean flag = false;
        for (int i = 0; i < reservaciones.size(); i++) {
            int h = reservaciones.get(i).getHabitacion();
            if (reservaciones.get(i).getId().equals(id)) {
                int index = i;
                for (int j = 0; j < individuales.size(); j++) {
                    if (h == individuales.get(j).getNumeroHabitacion()) {
                        flag = true;
                        individuales.get(j).setStatus(true);
                        j = individuales.size();
                    }
                }
                for (int k = 0; k < habitacionDobles.size(); k++) {
                    if (h == habitacionDobles.get(k).getNumeroHabitacion()) {
                        flag = true;
                        habitacionDobles.get(k).setStatus(true);
                        k = habitacionDobles.size();
                    }
                }
                for (int l = 0; l < suites.size(); l++) {
                    if (h == suites.get(l).getNumeroHabitacion()) {
                        flag = true;
                        suites.get(l).setStatus(true);
                        l = suites.size();
                    }
                }
                reservaciones.remove(index);
            }
        }

        return flag;
    }

    public boolean updateReservacion(Reservacion reservacion){
        boolean flag = false;
        for (int i = 0; i < reservaciones.size(); i++) {
            if (reservacion.getId().equals(reservaciones.get(i).getId())) {
                flag = true;
                reservaciones.set(i, reservacion);
                i = reservaciones.size();
            }
        }
        return flag;
    }


}
