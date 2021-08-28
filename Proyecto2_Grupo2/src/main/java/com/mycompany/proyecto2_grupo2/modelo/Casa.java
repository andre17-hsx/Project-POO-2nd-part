/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import com.mycompany.proyecto2_grupo2.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author andya
 */
public class Casa {
    private Residente residente;
    private Ubicacion ubicacion;
    private String nombreVilla;
    private boolean ocupada;
    //private String id;
    
    public Casa(String nombreVilla, Ubicacion ubicacion, Residente residente,boolean ocupado){
        this.nombreVilla=nombreVilla;
        //this.villa= villa;
        this.ubicacion=ubicacion;
        this.residente=residente;
        this.ocupada=false;
    }
    
    public Casa(String nombreVilla, Ubicacion ubicacion,boolean ocupado){
        this(nombreVilla,ubicacion,null,ocupado); 
    }

    public Residente getResidente() {
        return residente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /*public int getManzana() {
        return manzana;
    }*/

    public String getnombreVilla() {
        return nombreVilla;
    }
    
    public boolean getOcupada(){
        return ocupada;
    }
    
    public void setOcupada(boolean o){
        this.ocupada = o;
    }
    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

   /* public void setManzana(int manzana) {
        this.manzana = manzana;
    }*/

    public void setnombreVilla(String nombreVilla) {
        this.nombreVilla = nombreVilla;
    }
    
    /*/public static List<Casa> cargarCasas(){
       String ruta = "Casas.txt";
       
    }*/
    
    public static List<Casa> cargarCasas(){
        String ruta = "Casas.txt";
        List<Casa> casas = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                String[] u = p[1].split(":");
                Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Casa c = new Casa(p[0],ubicacion,false);
                casas.add(c);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de las casas");
            ex.printStackTrace();
        }
        return casas;
    }
    
    public String verInformacion(){
        return "\nManzana: "+ubicacion.getX()+"\nVilla:"+ubicacion.getY();
    }
    
    
    
    /*public String buscarResidente(double manzana, double villa){
        List<Residente> residentes = Residente.cargarResidentes();
          for(Residente re: residentes){   
              if((re.getManzana()==manzana) && (re.getVilla()==villa)){
                  return re.getNombre();
              }  
        }
        return "CASA VACIA";
    }*/
}  

