/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import static com.mycompany.proyecto2_grupo2.data.AdminsData.escribirAdmins;
import static com.mycompany.proyecto2_grupo2.data.CasasData.escribirCasas;
import static com.mycompany.proyecto2_grupo2.data.ResidentesData.escribirResidentes;
import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Ubicacion;
import java.util.ArrayList;

/**
 *
 * @author andya
 */
public class InicializarSistema {
     public static void main(String[] args){
         //Creo mis admins
        ArrayList<Administrador> admins = new ArrayList<Administrador>();
        admins.add(new Administrador("admin", "admin"));
        escribirAdmins(admins);
        
        //Creo mis residentes
        ArrayList<Residente> residentes = new ArrayList<Residente>();
        residentes.add(new Residente("andaapol", "1234", "Andre", "andyagpolo@gmail.com", "masculino"));
        residentes.add(new Residente("jeffras", "abcd", "Jefferson", "correo@gmail.com", "masculino"));
        escribirResidentes(residentes);
        
        //Creo mis casas
        ArrayList<Casa> casas = new ArrayList<Casa>();
        casas.add(new Casa(new Ubicacion(70.0,93.0)));
        casas.add(new Casa(new Ubicacion(250.0,93.0)));
        casas.add(new Casa(new Ubicacion(550.0,93.0)));
        casas.add(new Casa(new Ubicacion(167.0,301.0)));
        casas.add(new Casa(new Ubicacion(390.0,301.0)));
        escribirCasas(casas);
    }
     
}