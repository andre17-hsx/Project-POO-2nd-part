/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.CasasData;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            List<Casa> casas = CasasData.leerCasas();
            for(Casa ca: casas){
                ImageView casa= crearCasa();
                paneMapa.getChildren().add(casa);
                casa.setLayoutX(ca.getUbicacion().getX());
                casa.setLayoutY(ca.getUbicacion().getY());
                /*/Label l= new Label();
                l.setLayoutX(ca.getUbicacion().getX());
                l.setLayoutY(ca.getUbicacion().getY());/*/
                //casa.setOnMouseMoved(eh);
                casa.setOnMouseDragged((MouseEvent ev)->{
                            //l.setText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente"+ca.getResidente().getNombre());
                           // Alert al= new Alert(Alert.AlertType.INFO);
                           Alert al= new Alert(Alert.AlertType.INFORMATION);
                           al.setContentText("No existe este usuario");
                           al.show();
                        });
                
                /*/Tooltip tooltip = new Tooltip();
                tooltip.setText("Manzana"+String.valueOf(ca.getUbicacion().getX())+"\n"+"Villa"+String.valueOf(ca.getUbicacion().getY())+"\n"+"Residente"+ca.getResidente().getNombre());
                //c.setTooltip(tooltip);
                l.setTooltip(tooltip);/*/
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
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
