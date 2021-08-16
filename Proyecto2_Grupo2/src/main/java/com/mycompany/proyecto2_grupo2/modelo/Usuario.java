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
public abstract class Usuario {
    private String usuario;
    private String password;
    
    
    public Usuario(String usuario, String password){
        this.usuario=usuario;
        this.password=password;
        
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    
    public abstract List<Usuario> leerUsuarios();
}
