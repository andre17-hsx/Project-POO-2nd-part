/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.modelo.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button btnCambiarPin;
    
    private static Residente residente;
    @FXML
    private Button btnVerDatos;
    @FXML
    private MenuItem btnRegistroVehiculo;
    @FXML
    private MenuItem btnRegistroVisitas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /*/ nombreR.setText(residente.getNombre());
        correoR.setText(residente.getCorreo());
        pinR.setText(residente.getPin());
        manzanaR.setText(String.valueOf(residente.getCasa().getUbicacion().getX()));
        villaR.setText(String.valueOf(residente.getCasa().getUbicacion().getY()));/*/
    }    

    @FXML
    private void cambiarPin(MouseEvent event) {
        residente.setPin(txtNuevoPin.getText());
    }
    
    

    @FXML
    private void verDatos(MouseEvent event) {
        this.nombreR.setText(residente.getNombre());
        this.correoR.setText(residente.getCorreo());
        this.pinR.setText(residente.getPin());
        this.manzanaR.setText(String.valueOf(residente.getCasa().getUbicacion().getX()));
        this.villaR.setText(String.valueOf(residente.getCasa().getUbicacion().getY()));
    }
    
    public void setResidente(Residente residente){
        this.residente=residente; 
    }

    public static Residente getResidente() {
        return residente;
    }
    

    @FXML
    private void Vehiculos(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaVehiculos.fxml"));
            
                        Parent root = loader.load();
                        VistaVehiculosController vc = loader.<VistaVehiculosController>getController();
                        System.out.println(vc);
                        vc.setResidente(VistaResidenteController.getResidente());
                        App.scene.setRoot(root);
                        
                    }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                    }
    }

    @FXML
    private void Visitas(ActionEvent event) {
    }
}
