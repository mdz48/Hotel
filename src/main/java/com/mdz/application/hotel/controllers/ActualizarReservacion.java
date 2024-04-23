package com.mdz.application.hotel.controllers;

import com.mdz.application.hotel.App;
import com.mdz.application.hotel.models.Reservacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ActualizarReservacion {

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button exitButton;

    @FXML
    private ComboBox<Integer> habitacionComboBox;

    @FXML
    private TextField idTxt;

    @FXML
    private ComboBox<Integer> peopleComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    void onClickExitButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        if (peopleComboBox.getValue() == null || tipoComboBox.getValue() == null || idTxt.getText().isEmpty() || habitacionComboBox.getValue() == null || datePicker.getValue() == null) {
            String contenido = "Rellene todos los campos";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {

            boolean status = false;
            int index = 0;
            if (idTxt.getText().length() == 3) {
                while (!status && index < App.getHotel().getReservaciones().size()) {
                    if (App.getHotel().getReservaciones().get(index).getId().indexOf(idTxt.getText()) >= 0) {
                        status = true;
                        Reservacion reservacion = new Reservacion(datePicker.getValue(), App.getHotel().getReservaciones().get(index).getId(), habitacionComboBox.getValue(), peopleComboBox.getValue());
                        if (App.getHotel().updateReservacion(reservacion)) {
                            String contenido = "Se Actualizó";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        } else {
                            String contenido = "No se pudo completar";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        }
                    }
                    index++;
                }
                if (!status) {
                    String contenido = "ID inexistente";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            } else {
                String contenido = "Ingrese únicamente 3 dígitos";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        }
    }

    @FXML
    void tipoSelectedComboBox(ActionEvent event) {
        String valor = tipoComboBox.getValue();
        ObservableList<Integer> list;
        ArrayList<Integer> habitaciones = new ArrayList<>();
        ObservableList<Integer> numHabitacion;
        if (valor.equals("Individual")){
            list = FXCollections.observableArrayList(1);
            for (int i = 0; i < App.getHotel().getIndividuales().size(); i++) {
                if (App.getHotel().getIndividuales().get(i).isStatus() == true) {
                    habitaciones.add(App.getHotel().getIndividuales().get(i).getNumeroHabitacion());
                }
            }
            numHabitacion = FXCollections.observableArrayList(habitaciones);
        } else if (valor.equals("Doble")) {
            list = FXCollections.observableArrayList(1,2,3);
            for (int i = 0; i < App.getHotel().getHabitacionDobles().size(); i++) {
                if (App.getHotel().getHabitacionDobles().get(i).isStatus() == true) {
                    habitaciones.add(App.getHotel().getHabitacionDobles().get(i).getNumeroHabitacion());
                }
            }
            numHabitacion = FXCollections.observableArrayList(habitaciones);
        } else {
            list = FXCollections.observableArrayList(1,2,3,4,5,6,7);
            for (int i = 0; i < App.getHotel().getSuites().size(); i++) {
                if (App.getHotel().getSuites().get(i).isStatus() == true) {
                    habitaciones.add(App.getHotel().getSuites().get(i).getNumeroHabitacion());
                }
            }
            numHabitacion = FXCollections.observableArrayList(habitaciones);
        }
        peopleComboBox.setItems(list);
        habitacionComboBox.setItems(numHabitacion);
    }
    public void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList("Individual", "Doble",  "Suite");
        tipoComboBox.setItems(list);
    }

}
