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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaReportesController implements Initializable {

    @FXML
    private Pane paneGrafico1;
    @FXML
    private Pane paneGrafico2;
    @FXML
    private MenuItem btnMapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarMapa(ActionEvent event) {
         try{
                            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaAdministrador.fxml"));
            
                            Parent root = loader.load();
                            VistaAdministradorController ic = loader.<VistaAdministradorController>getController();
                            System.out.println(ic);
                            App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }
    
}
