/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeras
 */
public class VistaSimulacionResidentesController implements Initializable {

    @FXML
    private Tab tabVehiculo;
    @FXML
    private Pane paneVehiculo;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Tab tabPeaton;
    @FXML
    private Pane panePeaton;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;
    @FXML
    private Button btn_0;
    @FXML
    private Label lblPinPantalla;
    @FXML
    private Button btnTerminarSimulacion;
    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtPinPantalla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void scanearPin(MouseEvent event){
        String pin =  lblPinPantalla.getText();
        if(buscarPin(pin)){
            mostrarIngresoPeaton();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Authentication error");
            alert.setTitle("PIN ERROR..!");
            alert.setContentText("El PIN ingresado es INCORRECTO, porfavor vuelva a ingresar correctamente");
            alert.showAndWait();
            lblPinPantalla.setText("");
            txtPinPantalla.clear();
        
        }
        
    }
    
    
    public void mostrarIngresoPeaton(){
        //IMPLEMENTAR ANIMACION DE INGRESO DE IUN PEATON
    
    }
    
    public void mostrarIngresoVehiculo(){
        //IMPLEMENTAR ANIMACION DE INGRESO DE UN VEHICULO
    }
    
    public boolean buscarPin(String pin){
        boolean encontrado = false;
        //IMPLEMENTAR BUSCAR EL PIN Y DEVOLVER TRUE SI COINCIDE
        //O FALSE SI ES INCORRECTO
        
        return encontrado;
    }
    
    @FXML
    public void scanearMatricula(MouseEvent event){
        
        if(buscarMatricula(txtMatricula.getText())){
            mostrarIngresoVehiculo();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Authentication error");
            alert.setTitle("MATRICULA ERROR..!");
            alert.setContentText("No existe ningun auto con la MATRICULA INGRESADA, porfavor vuelva a ingresar correctamente");
            alert.showAndWait();
            txtMatricula.clear();
        }
    }
    
    public boolean buscarMatricula(String cadena){
        boolean encontrado = false;
        //IMPLEMENTAR EL METODO BUSCAR MATRICULA DE LOS VEHICULOS DE LA BASE DE DATOS
        // vehiculos.dat
        
        
        return encontrado;
    }
    

    @FXML
    public void terminarSimulacion(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaInicio.fxml"));
            Parent root = loader.load();
            VistaInicioController vi = loader.<VistaInicioController>getController();
            System.out.println(vi);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
    
    }
    
}
