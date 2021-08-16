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

public class VistaPrincipalController{

    @FXML
    private Button btnInicioSesion;
    @FXML
    private Button btnSimular;

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
