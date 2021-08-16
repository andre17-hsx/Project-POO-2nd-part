/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.util.List;

/**
 *
 * @author andya
 */
public class Casa {
    private Residente residente;
    private Ubicacion ubicacion;
    private int manzana;
    private int villa;
    
    public Casa(int manzana, int villa, Ubicacion ubicacion, Residente residente){
        this.manzana=manzana;
        this.villa= villa;
        this.ubicacion=ubicacion;
        this.residente=residente;
        
    }

    public Residente getResidente() {
        return residente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public int getManzana() {
        return manzana;
    }

    public int getVilla() {
        return villa;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setManzana(int manzana) {
        this.manzana = manzana;
    }

    public void setVilla(int villa) {
        this.villa = villa;
    }
    
    /*/public static List<Casa> cargarCasas(){
       String ruta = "Casas.txt";
       
    }*/
}  

