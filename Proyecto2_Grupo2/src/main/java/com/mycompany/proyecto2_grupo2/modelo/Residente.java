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
public class Residente extends Usuario{
    private Genero genero;
    private String pin;
    
    public Residente(String usuario, String password) {
        super(usuario, password);
    }
    
    public Residente(String usuario, String password, Genero genero, String pin){
        this(usuario,password);
        this.genero=genero;
        this.pin=pin;
    }

    @Override
    public List<Usuario> leerUsuarios() {
        List<Usuario> residentes = Arrays.asList(
            new Administrador("Maria", "4567"),
            new Administrador("Jose", "xyz"));
        return residentes;
    }
}
