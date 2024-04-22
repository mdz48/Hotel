package com.mdz.application.hotel.controllers;

import com.mdz.application.hotel.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CancelarController {

    @FXML
    private Button exitButton;

    @FXML
    private TextField idTxt;

    @FXML
    private Button saveButton;

    @FXML
    void onClickExitButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        boolean status = false;
        int index = 0;
        if (idTxt.getText().length() == 3) {
            while (!status && index < App.getHotel().getReservaciones().size()) {
                if (App.getHotel().getReservaciones().get(index).getId().indexOf(idTxt.getText()) >= 0) {
                    status = true;
                    if (App.getHotel().cancelarReservacion(App.getHotel().getReservaciones().get(index).getId())) {
                        String contenido = "Se cancelo";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    } else {
                        String contenido = "No se pudo compeltar";
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
