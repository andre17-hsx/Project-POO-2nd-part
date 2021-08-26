/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaInicioSesionController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContrasenia;
    @FXML
    private Button btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void Ingresar(MouseEvent event){
        String usuario= txtUsuario.getText();
        String password= txtContrasenia.getText();
        List<Usuario> usuarios = Usuario.leerUsuarios();
        boolean encontrado = false;
        for(Usuario u: usuarios){
            if(u.getUsuario().equals(usuario) && u.getPassword().equals(password)){
                encontrado = true;
                if(u instanceof Administrador){
                    try{
                        /*/FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaAdmin.fxml"));
                        Parent viewAdmin = loader.load();
                        Scene sc= new Scene(viewAdmin);
                        Stage st= new Stage();
                        st.setScene(sc);
                        st.show();
                        /*/FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaAdmin.fxml"));
                        Parent root = loader.load();
                        VistaAdminController ac = loader.<VistaAdminController>getController();
                        System.out.println(ac);
                        
                        App.scene.setRoot(root);
                        
                    }catch(IOException ex){
                        System.out.println("No se ha podiddo cargar la vista");
                    }
                }
                else if(u instanceof Residente){
                    try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
                        Parent root = loader.load();
                        VistaResidenteController rc= loader.<VistaResidenteController>getController();
                        System.out.println(rc);
                        App.scene.setRoot(root);
                        /*/Scene sc= new Scene(viewResidente);
                        Stage st= new Stage();
                        st.setScene(sc);
                        st.show();*/
                        
                    }catch(IOException ex){
                        System.out.println("No se ha podiddo cargar la vista");
                    }
                }
            }//FIN DEL IF DE ADMIN Y RESIDENTE
        } // FIN DEL FOR
        
        if(!encontrado){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("authentication error");
                alert.setTitle("Logging Error");
                alert.setContentText("El user o password ingresados, son incorrectos");
                alert.showAndWait();
                txtUsuario.clear();
                txtContrasenia.clear();
        }
        
    }
    
 
}