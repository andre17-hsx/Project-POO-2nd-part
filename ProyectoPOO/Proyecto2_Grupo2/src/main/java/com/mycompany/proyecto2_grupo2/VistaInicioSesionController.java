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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaInicioSesionController implements Initializable {

    @FXML
    private TextField lblUsuario;
    @FXML
    private TextField lblContraseña;
    @FXML
    private Button btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ingresar(MouseEvent event) /*/throws IOException, ClassNotFoundException/*/ {
        
            String usuario = lblUsuario.getText();
            String contraseña= lblContraseña.getText();
            boolean c=false;
            try /*/throws IOException, ClassNotFoundException/*/ {
             for (Residente r: ResidentesData.leerResidentes()){
                if(r.getUser().equals(usuario) && r.getContraseña().equals(contraseña)){
                    try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
            
                        Parent root = loader.load();
                        VistaResidenteController rc = loader.<VistaResidenteController>getController();
                        System.out.println(rc);
                        rc.setResidente(r);
                        App.scene.setRoot(root);
                        
                    }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                    }
                    c= true;
                }
                else{
                    Alert al= new Alert(Alert.AlertType.ERROR);
                    al.setContentText("No existe este usuario");
                    al.show();
                }
            }
            if(c==false){
                try {
                    for (Administrador a: AdminsData.leerAdmins()){
                        if(a.getUser().equals(usuario) && a.getContraseña().equals(contraseña)){
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
                        else{
                            Alert al= new Alert(Alert.AlertType.ERROR);
                            al.setContentText("No existe este usuario");
                            al.show();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        }
        
        /*/public String ObtenerResidente(){
            String usuario = lblUsuario.getText();
            String contraseña= lblContraseña.getText();
            return usuario, contraseña;
        }/*/
}
