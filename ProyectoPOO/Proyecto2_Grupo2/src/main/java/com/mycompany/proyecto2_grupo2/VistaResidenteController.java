/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaResidenteController implements Initializable {

    @FXML
    private Menu btnInformacion;
    @FXML
    private MenuItem btnRegistroVehiculo;
    @FXML
    private MenuItem btnRegistrarVisitas;
    @FXML
    private Label nombreR;
    @FXML
    private Label correoR;
    @FXML
    private Label manzanaR;
    @FXML
    private Label villaR;
    @FXML
    private Label pinR;
    @FXML
    private TextField txtNuevoPin;
    @FXML
    private Button btnCmabiarPin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarVehiculo(ActionEvent event) {
    }

    @FXML
    private void registroVisitas(ActionEvent event) {
    }

    @FXML
    private void mostrarInfo(ActionEvent event) {
    }

    @FXML
    private void cambiarPin(MouseEvent event) {
    }
    
}
