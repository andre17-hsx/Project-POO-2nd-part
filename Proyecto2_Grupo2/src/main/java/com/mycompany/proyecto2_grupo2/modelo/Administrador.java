/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andya
 */
public class Administrador extends Usuario{
    
    private String nombre;
    private String correo;
    
    public Administrador(String usuario, String password){
        super(usuario,password);
    }
    
    public Administrador(String usuario, String password, String nombre, String correo){
        this(usuario,password);
        this.nombre=nombre;
        this.correo=correo;
        
    }

    @Override
    public List<Usuario> leerUsuarios() {
        List<Usuario> admins = Arrays.asList(
            new Administrador("andaapol", "1234"),
            new Administrador("joffreras", "abcd"));
        return admins;
    }
}
