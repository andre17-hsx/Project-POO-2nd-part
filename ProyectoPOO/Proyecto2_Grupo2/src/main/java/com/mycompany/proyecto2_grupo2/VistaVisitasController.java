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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaVisitasController implements Initializable {


    @FXML
    private Menu btnVisitas;
    @FXML
    private MenuItem btnDatos;
    @FXML
    private MenuItem btnVehiculos;
    @FXML
    private Button btnRegistrarVisita;
    @FXML
    private TextField txtfechaInicio;
    @FXML
    private TextField txtFechaFin;
    @FXML
    private Button btnBuscarVisitas;
    @FXML
    private TableColumn<?, ?> filaNombre;
    @FXML
    private TableColumn<?, ?> filaCedula;
    @FXML
    private TableColumn<?, ?> filaCodigo;
    @FXML
    private TableColumn<?, ?> filaFecha;
    @FXML
    private TableColumn<?, ?> filaEstado;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtFecha;
    
    private Residente residente;
    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setResidente(Residente r){
        this.residente=residente;
        
    }
    
    public Residente getResidente(){
        return residente;
    }
    @FXML
    private void VerDatos(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
            
                        Parent root = loader.load();
                        VistaResidenteController ic = loader.<VistaResidenteController>getController();
                        System.out.println(ic);
                        ic.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void registrarVehiculo(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaVehiculos.fxml"));
            
                        Parent root = loader.load();
                        VistaVehiculosController vc = loader.<VistaVehiculosController>getController();
                        System.out.println(vc);
                        vc.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }


}
