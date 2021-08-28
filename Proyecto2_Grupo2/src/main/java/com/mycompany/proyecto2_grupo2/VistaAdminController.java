/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaAdminController implements Initializable {

    @FXML
    private Pane paneMapaCiudadela;
    @FXML
    private MenuItem MenuReportes;
    @FXML
    private Menu MenuMapa;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //mostrar vista inicial con la información de las casas actuales
                // TODO
        List<Casa> casas = Casa.cargarCasas();
        List<Residente> residentes = Residente.cargarResidentes();
        for(Casa ca: casas){
            Circle c = new Circle(5,Color.YELLOW);
            Label l = new Label(ca.getnombreVilla());
            StackPane st = new StackPane();
            st.getChildren().addAll(c,l);
            
            //agregar el stackpane al panelMapa
            paneMapaCiudadela.getChildren().addAll(st);
            
            //fijar la ubicacion del st en la ubicacion de la tienda
            st.setLayoutX(ca.getUbicacion().getX());
            st.setLayoutY(ca.getUbicacion().getY());
            
            String nombre = buscarResidente(ca.getUbicacion().getX(),ca.getUbicacion().getY());
            
            final Tooltip tooltip = new Tooltip();
            tooltip.setText(nombre+ca.verInformacion());
            //c.setTooltip(tooltip);
            l.setTooltip(tooltip);
            
            
            st.setOnMouseClicked(
                    //para que no se propague
                    (MouseEvent ev) ->{
                        /*/
                        1: Aqui muestro una nueva scene para ingresar los datos
                        2: Obtengo los datos de los textfields
                        3: Con esos datos modifico el archivo Casas.txt (Creo que las casas deberian tener un pin, para relacionarlo con mi Residente)
                        4: Cierro la scene.
                        
                        /*/
                        
                        
                        //panelAgente.getChildren().clear();
                        //Agente a = t.getAgente();
                        //Label lagNombre = new Label(a.getNombre());
                        //Label lagCedula = new Label(a.getCedula());
                        
                        ImageView imgview = null;
                       /* try{
                             //agrego la imagen del agente
                                InputStream input = App.class.getResource(a.getImage_path()).openStream();
                                Image img = new Image(input, 50,50, true, true);
                                imgview = new ImageView(img);
                                 }catch(NullPointerException | IOException ex){
                                     //no hay la imagen buscada
                                    imgview = new ImageView();
                                 } 
                        //panelAgente.getChildren().addAll(imgview,lagNombre,lagCedula);
                        ev.consume();*/
                    }
            );
            
           // panelAgente.getChildren().clear();
              
        }
    }    
    
    
    
    /*/public String buscarResidente(){
        List<Residente> residentes = Residente.cargarResidentes();
          for(Residente re: residentes){   
              if((re.getManzana()==manzana) && (re.getVilla()==villa)){
                  return re.getNombre();
              }  
        }
        return "CASA VACIA";
    }/*/

    @FXML
    private void VerReportes(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaReportes.fxml"));
                        Parent root = loader.load();
                        VistaReportesController repc= loader.<VistaReportesController>getController();
                        System.out.println(repc);
                        App.scene.setRoot(root);
        }catch(IOException ex){
                        System.out.println("No se ha podiddo cargar la vista");
                    }
    }
    
}
