/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import static com.mycompany.proyecto2_grupo2.VistaAdministradorController.enviarCorreo;
import com.mycompany.proyecto2_grupo2.data.VehiculosData;
import com.mycompany.proyecto2_grupo2.data.VisitantesData;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.util.Properties;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import javafx.application.Platform;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaVisitasController implements Initializable {


    @FXML
    private Menu btnVisitas;
    @FXML
    private MenuItem btnDatos;
    @FXML
    private MenuItem btnVehiculos;
    @FXML
    private Button btnRegistrarVisita;
    @FXML
    private TextField txtfechaInicio;
    @FXML
    private TextField txtFechaFin;
    @FXML
    private Button btnBuscarVisitas;
    @FXML
    private TableView<Visitante> tvDatosVisitantes;
    @FXML
    private TableColumn<Visitante,String> filaNombre;
    @FXML
    private TableColumn<Visitante,String> filaCedula;
    @FXML
    private TableColumn<Visitante,String> filaCodigo;
    @FXML
    private TableColumn<Visitante,LocalDate> filaFecha;
    @FXML
    private TableColumn<Visitante,String> filaEstado;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtFecha;
    
    private Residente residente;
    @FXML
    private TextField txtHora;
    
    private Visitante visitanteNuevo;
    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setResidente(Residente r){
        this.residente=residente;
        
    }
    
    public Residente getResidente(){
        return residente;
    }
    @FXML
    private void VerDatos(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
            
                        Parent root = loader.load();
                        VistaResidenteController ic = loader.<VistaResidenteController>getController();
                        System.out.println(ic);
                        ic.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void registrarVehiculo(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaVehiculos.fxml"));
            
                        Parent root = loader.load();
                        VistaVehiculosController vc = loader.<VistaVehiculosController>getController();
                        System.out.println(vc);
                        vc.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void registrarVisitas(MouseEvent event) throws ParseException, IOException, ClassNotFoundException{
        validarEntradaDatos();
    }
    
        
    public static boolean isInteger(String cadena) {
        int numero;
        try {
            numero = Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    
    public static boolean validarFecha(String cadena) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             try{
                df.parse(cadena);
                return true;
            }catch(DateTimeParseException n){
                return false;
            }catch(ParseException e){
                return false;
            }
    }
    
    public static boolean validarHora(String cadena){    
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
        try{
            LocalTime.parse(cadena);
            return true;
        }catch(DateTimeParseException n){
            return false;
        }
    }
    
    public void validarEntradaDatos() throws ParseException, IOException, ClassNotFoundException{
        Thread t2 = new Thread();
        if ((txtNombre.getText().trim().isEmpty()) && (txtCedula.getText().trim().isEmpty())
                && (txtCorreo.getText().trim().isEmpty()) && (txtFecha.getText().trim().isEmpty())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("CAMPOS VACIO DEBE INGRESAR DATOS...!");
            al.showAndWait();
        } else if (txtNombre.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (txtCedula.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (!isInteger(txtCedula.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("INGRESA SOLO NUMEROS...!, Por favor ingrese nuevamente!");
            al.showAndWait();
            txtCedula.clear();
        } else if (txtCorreo.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (txtFecha.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();

        } else if (!validarFecha(txtFecha.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();
        } else if (txtHora.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (!validarHora(txtHora.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("El formato de la hora es INCORRECTA por favor Ingrese <HH:mm:ss>..!");
            al.showAndWait();
        } else {
            String nombre = txtNombre.getText();
            String cedula = txtCedula.getText();
            String correo = txtCorreo.getText();
            LocalDate fec = LocalDate.parse(txtFecha.getText());
            LocalTime hor = LocalTime.parse(txtHora.getText());
            String codigo = randomString();
            Visitante vi = new Visitante(nombre, cedula, correo, fec, hor, codigo);
            if (validarVisitante(vi)) {
                ArrayList<Visitante> visitantes = VisitantesData.leerVisitantes();
                visitantes.add(vi);
                VisitantesData.escribirVisitantes(visitantes);
                visitanteNuevo = vi;
                enviarClaveAcceso eCA = new enviarClaveAcceso();
                t2 = new Thread(eCA);
                t2.setDaemon(true);
                t2.start();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("SUCESSFULL");
                alert.setContentText("Su VISITANTE Se registro correctament..!");
                alert.showAndWait();
                txtNombre.clear();
                txtCedula.clear();
                txtCorreo.clear();
                txtFecha.clear();
                txtHora.clear();
            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("VISITANTE ERROR");
                al.setTitle("Error al registrar");
                al.setContentText("Ya existe un visitante paara éste día, solo una visita diaria");
                al.showAndWait();
                txtFecha.clear();
                txtHora.clear();
            }

        }
    }
    
    public static boolean validarVisitante(Visitante newVisitante) throws IOException, ClassNotFoundException{
        ArrayList<Visitante> visitantes = VisitantesData.leerVisitantes();
        for(Visitante v:visitantes){
            if(v.getNombre().toLowerCase().equals(newVisitante.getNombre().equals(v))){
                if(v.getFecha().toString().equals(v.getFecha().toString())){
                    return false;
                }
            
            }
        }
        return true;
    
    }
    
    public String randomString() {
        String alphanumeric;
        StringBuilder builder;

        alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        //create the StringBuffer
        builder = new StringBuilder(8);

        for (int m = 0; m < 8; m++) {

            // generate numeric
            int myindex
                    = (int) (alphanumeric.length()
                    * Math.random());

            // add the characters
            builder.append(alphanumeric.charAt(myindex));
        }

        return builder.toString();
    }
    
    
    public static void enviarCorreo(Visitante v) {
        
        //Inicializamos nuestras credenciales de remitente
        String remitente = "sistemabienesraicesg6@gmail.com";
        String clave = "sbr123456.";
        String destino = "jeraslindao@gmail.com"; //A quien le quieres escribir.
        String asunto = "PROYECTO POO - 2DO PARCIAL - GRUPO 2";
        String visitante = v.getNombre();
        String fecha = v.getFecha().toString();
        String hora= v.getHora().toString();
        String codigo = v.getCodigo();
        //Configuramos las credenciales, host, puerto para enviar correo, usando smtp de Gmail
        Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "false");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);
            

        
        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session); //mensaje basado con la configuracion inicial que creamos

        //Controlamos el envio smtp con un try-catch
        try{
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            mensaje.setSubject(asunto);
            mensaje.setText("Estimado Sr/a." +visitante+",\n\nSu visita esta programada para el dia, "+
                    fecha+"a las: "+hora+"\n\n\n no olvide su clave la cual es la siguiente\n\n:"+
                    "Password\t="+codigo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("\n*** Correo Enviado ****");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
    
      
    @FXML
    public void filtrarVisitasIntervalo(LocalDate inicio,LocalDate fin) throws ParseException, IOException, ClassNotFoundException {
    tvDatosVisitantes = new TableView<>();
    
    ObservableList<Visitante> visiRango = FXCollections.observableArrayList();
    visiRango.add(new Visitante("jaime","cedula","correo1",LocalDate.parse("2021-10-10"),LocalTime.parse("10:10:10"),"ADOKKIUY"));
    visiRango.add(new Visitante("jASD","cedula","correo1",LocalDate.parse("2021-10-10"),LocalTime.parse("10:10:10"),"ADOKKIUY"));
    visiRango.add(new Visitante("jULIO","cedula","correo1",LocalDate.parse("2021-10-10"),LocalTime.parse("10:10:10"),"ADOKKIUY"));
    tvDatosVisitantes.setItems(visiRango);
    
    TableColumn columnaDatos = new TableColumn("DATOS DE VISITANTES");
    TableColumn<Visitante,String> filaNombre = new TableColumn("Nombre");
    filaNombre.setCellValueFactory(new PropertyValueFactory <Visitante,String>("nombre"));
    
    TableColumn<Visitante,String> filaCedula = new TableColumn("Cedula");
    filaNombre.setCellValueFactory(new PropertyValueFactory <Visitante,String>("cedula"));
    
    TableColumn<Visitante,String> filaCodigo= new TableColumn("Codigo");
    filaNombre.setCellValueFactory(new PropertyValueFactory <Visitante,String>("codigoAcceso"));
    
    TableColumn<Visitante,String> filaFecha=new TableColumn("Fecha");
    filaNombre.setCellValueFactory(new PropertyValueFactory <Visitante,String>("2021-10-10"));
    
    TableColumn<Visitante,String> filaEstado=new TableColumn("Estado");
    filaNombre.setCellValueFactory(new PropertyValueFactory <Visitante,String>("estado"));
    columnaDatos.getColumns().addAll(filaNombre,filaCedula,filaCodigo,filaFecha,filaEstado);
    tvDatosVisitantes.getColumns().addAll(columnaDatos);

    }
    
    @FXML
    public void buscar(MouseEvent event) throws ParseException, IOException, ClassNotFoundException
    ,DateTimeParseException{
        LocalDate fechaIn;
        LocalDate fechaFinal;
        
        if ((txtfechaInicio.getText().trim().isEmpty()) &&(txtFechaFin.getText().trim().isEmpty()) ) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("NO HA INGRESADO NADA..!");
            al.showAndWait();
        }else if(txtfechaInicio.getText().trim().isEmpty()){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("No ha ingresado RANGO de FECHA DE INICIO..!");
            al.showAndWait();
        }else if(txtFechaFin.getText().trim().isEmpty()){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("No ha ingresado RANGO de FECHA FINAL..!");
            al.showAndWait();
        } else if (!validarFecha(txtfechaInicio.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();
        }else if(!validarFecha(txtFechaFin.getText())){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();
        }else{
                fechaIn= LocalDate.parse(txtfechaInicio.getText());
                fechaFinal= LocalDate.parse(txtFechaFin.getText());
                filtrarVisitasIntervalo(fechaIn,fechaFinal);
        
        
        }


    }
    
    
   class enviarClaveAcceso implements Runnable {

        @Override
        public void run() {
            try {
                Platform.runLater(() -> {
                    enviarCorreo(visitanteNuevo);
                });

                Thread.sleep(500);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
    
    
}//FIN DE LA CLASE
