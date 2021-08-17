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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andya
 */
public class Administrador extends Usuario{
    
    //private String nombre;
    //private String correo;
    
    /*public Administrador(String usuario, String password,String nombre,String correo){
        super(usuario,password,nombre,correo);
    }*/
    
    public Administrador(String usuario, String password, String nombre, String correo){
        super(usuario,password,nombre,correo);
    }
    
    
    /*public static List<Administrador> cargarAdministradores(){
        String ruta = "Administradores.txt";
        List<Administrador> administradores = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                //String[] u = p[1].split(":");
                //Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Administrador a = new Administrador(p[0],p[1],p[2],p[3]);
                administradores.add(a);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los Administradores");
            ex.printStackTrace();
        }
        return administradores;
    }*/

    
    /*/public List<Usuario> leerUsuarios() {
        List<Usuario> admins = Arrays.asList(
            new Administrador("andaapol", "1234"),
            new Administrador("joffreras", "abcd"));
        return admins;
    }*/
}
