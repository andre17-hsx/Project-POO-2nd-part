/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.VisitantesData;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
 * @author jeras
 */
public class VistaSimulacionVisitanteConCodigoController implements Initializable {

    @FXML
    private TextField txtCodigoAcceso;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnTerminarSimulacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    @FXML
    public void ingresarVisitante(MouseEvent event) throws IOException, ClassNotFoundException {

        if (txtCodigoAcceso.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Data error");
            alert.setTitle("VOID ERROR..!");
            alert.setContentText("NO HA INGRESADO NADA, por favor ingresa el codigo de acceso");
            alert.showAndWait();
            txtCodigoAcceso.clear();
        } else {

            if (validarClaveAcceso(txtCodigoAcceso.getText())) {
                mostrarIngresoVisitante();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Authentication error");
                alert.setTitle("CODIGO ERROR..!");
                alert.setContentText("la clave ingresada es INCORRECTA O HA CADUCADO porfavor vuelva a ingresar correctamente");
                alert.showAndWait();
                txtCodigoAcceso.clear();

            }

        }
        
        
    
    }
    
    
    public void mostrarIngresoVisitante(){
        //IMPLEMENTAR METODO PARA MOSTRAR INGRESO DE VISITANTE, UN GIF
        //IMAGEN O ALGO ASI
    
    }
    
    
    public boolean validarClaveAcceso(String clave) throws IOException, ClassNotFoundException{
        boolean encontrado = false;

        List<Visitante> visitantes = VisitantesData.leerVisitantes();
        int poslista = 0;
        
        for(Visitante v:visitantes){
            if(v.getCodigo().equals(clave) && (v.getValidezCodigo())){
                LocalDate fechaVisita = v.getFecha();
                LocalTime horaVisita = v.getHora();
                if (validarFechaHoraVisita(fechaVisita, horaVisita)) {
                    encontrado = true;
                    visitantes.get(poslista).setValidesCodigo(false);
                    escribirVisitantes(visitantes);
                    return encontrado;
                
                }
            }
            poslista=poslista+1;
        
        }
        
        return encontrado;
    
    }
    
    
    
    public boolean validarFechaHoraVisita(LocalDate f,LocalTime h){
        boolean valido = false;
        //IMPLEMENTAR LA VALIDACION DE FECHA Y HORA
        
        return valido;
    
    }
    
    
    @FXML
    public void terminarSimulacion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaInicio.fxml"));
            Parent root = loader.load();
            VistaInicioController vi = loader.<VistaInicioController>getController();
            System.out.println(vi);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }

    }

    private void escribirVisitantes(List<Visitante> visitantes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
