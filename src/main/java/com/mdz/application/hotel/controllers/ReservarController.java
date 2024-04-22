package com.mdz.application.hotel.controllers;

import com.mdz.application.hotel.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ReservarController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Integer> peopleComboBox;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    private ComboBox<Integer> habitacionComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private Button exitButton;

    @FXML
    void onClickExitButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        String valor = tipoComboBox.getValue();
        if (valor.equals("Individual")){
            if(App.getHotel().reservarIndividual(habitacionComboBox.getValue(), datePicker.getValue())){
                String contenido = "Se reservo";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            } else {
                String contenido = "Ya esta ocupado";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else if (valor.equals("Doble")) {
            if(App.getHotel().resevarDoble(habitacionComboBox.getValue(), datePicker.getValue())){
                String contenido = "Se reservo";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            } else {
                String contenido = "Ya esta ocupado";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else {
            if(App.getHotel().reservarSuite(habitacionComboBox.getValue(), datePicker.getValue())){
                String contenido = "Se reservo";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            } else {
                String contenido = "Ya esta ocupado";
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
