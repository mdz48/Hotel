package com.mdz.application.hotel.controllers;

import com.mdz.application.hotel.App;
import com.mdz.application.hotel.models.Habitaciones;
import com.mdz.application.hotel.models.Reservacion;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class HomeController {

    @FXML
    private Button disponibilidadButton;

    @FXML
    private Button reservarButton;

    @FXML
    private Button verButton;

    @FXML
    private Button cancelReservationButton;

    @FXML
    void onClickCancelButton(MouseEvent event) {
        App.newStage("cancelar-view", "cancelar");
    }

    @FXML
    void onClickDispoButton(MouseEvent event) {
        ArrayList<Habitaciones> habitaciones = App.getHotel().verDisponibles();
        if (habitaciones.isEmpty()) {
            String contenido = "No existen disponibles";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {
            StringBuilder contenido = new StringBuilder("Lista de Clientes:\n");
            for (int i = 0; i < habitaciones.size(); i++) {
                contenido.append(i+1).append(".- ").append(habitaciones.get(i)).append("\n");
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Clientes Registrados");
            alert.setHeaderText(null);
            alert.setContentText(contenido.toString());
            alert.showAndWait();
        }
    }

    @FXML
    void onClickReservarButton(MouseEvent event) {
        App.newStage("reservar-view", "Hola");
    }

    @FXML
    void onClickVerButton(MouseEvent event) {
        ArrayList<Reservacion> reservacions = App.getHotel().getReservaciones();
        StringBuilder contenido = new StringBuilder("Reservaciones:\n");
        for (int i = 0; i < reservacions.size(); i++) {
            contenido.append(i+1).append(".- ").append(reservacions.get(i)).append("\n");
            System.out.println(reservacions.get(i).getId());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clientes Registrados");
        alert.setHeaderText(null);
        alert.setContentText(contenido.toString());
        alert.showAndWait();

    }

    public void initialize(){
        App.getHotel().sethabitaciones();
    }

}
