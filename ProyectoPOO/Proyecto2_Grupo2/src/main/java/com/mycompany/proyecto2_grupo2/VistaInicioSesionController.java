/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.AdminsData;
import com.mycompany.proyecto2_grupo2.data.ResidentesData;
import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    
    private static String usuarioStatic;
    private static String contraseniaStatic;
    /**
     * Initializes the controller class.
     * 
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ingresar(MouseEvent event) throws IOException, ClassNotFoundException{

        String usuario = txtUsuario.getText();
        String password = txtContrasenia.getText();
        usuarioStatic =usuario;
        contraseniaStatic = password;

        List<Administrador> admins = AdminsData.leerAdmins();
        List<Residente> residentes = ResidentesData.leerResidentes();

        boolean encontrado = false;

        for (Administrador a : admins) {
            if (a.getUser().equals(usuario) && a.getContrasenia().equals(password)) {
                encontrado = true;
                try {
                    FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaAdministrador.fxml"));
                    Parent root = loader.load();
                    VistaAdministradorController ic = loader.<VistaAdministradorController>getController();
                    System.out.println(ic);
                    App.scene.setRoot(root);
                } catch (IOException ex) {
                    System.out.println("no se ha podido cargar la Vista");
                }
            }//FIN DEL IF DE ADMIN
        } // FIN DEL FOR
        
        for (Residente r : residentes) {
            if (r.getUser().equals(usuario) && r.getContrasenia().equals(password)) {
                encontrado = true;
                try {
                    FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
                    Parent root = loader.load();
                    VistaResidenteController rc = loader.<VistaResidenteController>getController();
                    System.out.println(rc);
                    rc.setResidente(r);
                    App.scene.setRoot(root);
                } catch (IOException ex) {
                    System.out.println("no se ha podido cargar la Vista");
                }
            }//FIN DEL IF DE RESIDENTE
        } // FIN DEL FOR
        
        if (!encontrado) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("authentication error");
            alert.setTitle("Logging Error");
            alert.setContentText("El user o password ingresados, son incorrectos");
            alert.showAndWait();
            txtUsuario.clear();
            txtContrasenia.clear();
        }

    }
    
    public Usuario getCredenciales(){
        Usuario u = new Usuario(usuarioStatic,contraseniaStatic);
        return u;
    }
}
