/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.VehiculosData;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaVehiculosController implements Initializable {

    @FXML
    private TextField txtMatricula;
    @FXML
    private Button btnRegistrarVehiculo;
    
    private Residente residente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    public void setResidente(Residente residente){
        this.residente=residente;
    }
    @FXML
    private void RegistrarnuevoVehiculo(MouseEvent event) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(new Vehiculo(txtMatricula.getText(), residente));
        VehiculosData.escribirVehiculos(vehiculos);
        Alert al= new Alert(Alert.AlertType.INFORMATION);
        al.setContentText("Se ha registrado su vehiculo");
        al.show();
    }
    
}
