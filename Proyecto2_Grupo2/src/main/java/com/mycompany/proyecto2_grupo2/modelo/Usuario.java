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
public abstract class Usuario {
    private String usuario;
    private String password;
    private String correo;
    private String nombre;
    
    
    public Usuario(String usuario, String password,String nombre,String correo){
        this.usuario=usuario;
        this.password=password;
        this.nombre=nombre;
        this.correo=correo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public static List<Usuario> leerUsuarios(){
        String ruta1 = "Administradores.txt";
        List<Usuario> usuarios = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta1).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                //String[] u = p[1].split(":");
                //Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Usuario a = new Administrador(p[0],p[1],p[2],p[3]);
                usuarios.add(a);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los Administradores");
            ex.printStackTrace();
        }
        
        String ruta2 = "Residentes.txt";
        List<Residente> residentes = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta2).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                String[] u = p[6].split(":");
                //Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Usuario r = new Residente(p[0],p[1],p[2],p[3],p[4],p[5],Double.valueOf(u[0]),Double.valueOf(u[1]));
                usuarios.add(r);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los Residentes");
            ex.printStackTrace();
        }
 
        return usuarios;
        /*List<Usuario> usuarios = Arrays.asList(
            new Administrador("andaapol", "1234"),
            new Administrador("jeras", "abcd"),
            new Residente("jose", "xyz"),
            new Residente("maria","4567")
        );
        return usuarios;*/
    }
    
    
    
}
