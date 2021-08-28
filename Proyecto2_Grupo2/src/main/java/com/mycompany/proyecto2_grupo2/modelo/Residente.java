/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import com.mycompany.proyecto2_grupo2.App;
import static com.mycompany.proyecto2_grupo2.modelo.Genero.Masculino;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andya
 */
public class Residente extends Usuario{
    private String genero;
    private String pin;
    private static List<Residente> listaresidentes;
    public Residente(String usuario, String password,String nombre,String correo) {
        super(usuario, password,nombre,correo);
    }
    
    public Residente(String usuario, String password,String nombre,String correo,String genero, String pin){
        this(usuario,password,nombre,correo);
        this.genero=genero;
        this.pin=pin;
        //this.nombre = nombre;
    
    }
    /*public String getNombre(){
        return nombre;
    }*/
    
    
    public static List<Residente> cargarResidentes(){
        String ruta = "Residentes.txt";
        //List<Residente> residentes = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                //String[] u = p[6].split(":");
                //Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Residente r = new Residente(p[0],p[1],p[2],p[3],p[4],p[5]);
                listaresidentes.add(r);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los Residentes");
            ex.printStackTrace();
        }
        return listaresidentes;
    }
    
    /*/@Override
    public List<Usuario> leerUsuarios() {
        List<Usuario> residentes = Arrays.asList(
            new Administrador("Maria", "4567"),
            new Administrador("Jose", "xyz"));
        return residentes;
    }*/
    
    public static Residente buscarResidente(String pin){
        for (Residente r: listaresidentes){
            if (r.pin.equals(pin)){
                return r;
            }
         }
        return null;
    }
}
