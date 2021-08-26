/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button btnInicioSesion;
    @FXML
    private Button btnSimular;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(MouseEvent event){
        
        try{
            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaInicioSesion.fxml"));
            
            Parent viewInicioSesion =loader.load();
            
            Scene sc= new Scene(viewInicioSesion);
            
            Stage st= new Stage();
            
            st.setScene(sc);
            
            st.show();
            
        }catch(IOException ex){
            System.out.println("no se ha podido cargar la vista");
        }
    }
    
}
