/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.CasasData;
import com.mycompany.proyecto2_grupo2.data.ResidentesData;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaAdministradorController implements Initializable {

    @FXML
    private Pane paneMapa;
    @FXML
    private Menu btnMapa;
    @FXML
    private MenuItem btnReportes;
    @FXML
    private GridPane formularioRegistro;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtGenero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ArrayList<Casa> casas = CasasData.leerCasas();
            for(Casa ca: casas){
                ImageView casa= crearCasa();
                paneMapa.getChildren().add(casa);
                casa.setLayoutX(ca.getUbicacion().getX());
                casa.setLayoutY(ca.getUbicacion().getY());
                //l.setLayoutX(ca.getUbicacion().getX());
                //l.setLayoutY(ca.getUbicacion().getY());
            
                casa.setOnMouseDragExited((MouseEvent ev0)->{
                            //l.setText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente"+ca.getResidente().getNombre());
                           // Alert al= new Alert(Alert.AlertType.INFO);
                           if(ca.getResidente()!=null){
                                Alert al= new Alert(Alert.AlertType.INFORMATION);
                                al.setContentText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente"+ca.getResidente().getNombre());
                                al.show();
                                
                           }
                           else{
                                
                                Alert al= new Alert(Alert.AlertType.INFORMATION);
                                al.setContentText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente: No hay Residente");
                                al.show();
                           }
                });
                           /*/final Tooltip tooltip = new Tooltip();
                                tooltip.setText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente: No hay Residente");
                                l.setTooltip(tooltip);/*/
                casa.setOnMouseClicked((MouseEvent ev)->{
                            formularioRegistro.setDisable(false);
                            formularioRegistro.setVisible(true);
                            //formularioRegistro.setLayoutY(200.0);
                            btnGuardar.setOnMouseClicked((MouseEvent ev1)->{
                                String nombre= txtNombre.getText();
                                String correo= txtCorreo.getText();
                                String genero= txtGenero.getText();
                                if(ca.getResidente()==null){
                                    double fiveDigits = 10000 + Math.random() * 90000;  int contraseña= (int) fiveDigits;
                                    double fourDigits = 1000 + Math.random() * 9000;  int pin= (int) fourDigits;
                                    
                                    
                                    try {
                                        ArrayList<Residente> residentes= ResidentesData.leerResidentes();
                                        //ArrayList<Casa> casas= CasasData.leerCasas();
                                        Residente r1= new Residente(nombre,String.valueOf(contraseña), nombre, correo, genero,String.valueOf(pin),ca);
                                        residentes.add(r1);
                                        ResidentesData.escribirResidentes(residentes);
                                        ca.setResidente(r1);
                                        System.out.println("Usuario: "+r1.getUser()+"\n"+"Contraseña: "+ r1.getContraseña()+"\n"+ "Pin: "+r1.getPin());
                                        CasasData.escribirCasas(casas);
                                        
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                        System.out.println("No se leyo algo en la linea 115");
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                         System.out.println("No se leyo algo en la linea 115");
                                    }
                                    
        
                                }
                                else{
                                  Alert al= new Alert(Alert.AlertType.ERROR);
                                  al.setContentText("Ya existe un Residente: "+ ca.getResidente().getNombre());
                                  al.show();  
                                }
                            formularioRegistro.setDisable(true);
                            formularioRegistro.setVisible(false);
                            txtNombre.clear();
                            txtCorreo.clear();
                            txtGenero.clear();
                            });
                            
                
                });
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("No se leyo algo en la linea 61");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("No se leyo algo en la linea 61");
        }
        
        
    }

    public ImageView crearCasa(){
        Image img = new Image(App.class.getResourceAsStream("Casa.png"));
        ImageView imgview = new ImageView(img);
        imgview.setFitHeight(100.0);
        imgview.setFitWidth(100.0);
        return imgview;
    }

    @FXML
    private void MostrarReportes(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaReportes.fxml"));
            Parent root = loader.load();
            VistaReportesController ic = loader.<VistaReportesController>getController();
            System.out.println(ic);
            App.scene.setRoot(root);
            
        }catch(IOException ex){
            System.out.println("no se ha podido cargar la vista");
        }
    }

    @FXML
    private void initialize(ActionEvent event) {
    }

    
}
