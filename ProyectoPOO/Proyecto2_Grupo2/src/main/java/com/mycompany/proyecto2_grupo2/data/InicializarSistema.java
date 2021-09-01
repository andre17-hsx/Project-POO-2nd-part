/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import static com.mycompany.proyecto2_grupo2.data.AdminsData.escribirAdmins;
import static com.mycompany.proyecto2_grupo2.data.CasasData.escribirCasas;
import static com.mycompany.proyecto2_grupo2.data.ResidentesData.escribirResidentes;
import static com.mycompany.proyecto2_grupo2.data.VehiculosData.escribirVehiculos;
import static com.mycompany.proyecto2_grupo2.data.VisitantesData.escribirVisitantes;
import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Ubicacion;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
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
        residentes.add(new Residente("andaapol", "1234", "Andre", "andyagpolo@gmail.com", "masculino","4567"));
        residentes.add(new Residente("jeferas", "1234", "Jefferson", "jeraslindao@espol.edu.ec", "masculino","4321"));
        escribirResidentes(residentes);
        
        //Creo mis casas
        ArrayList<Casa> casas = new ArrayList<Casa>();
        casas.add(new Casa(residentes.get(0),new Ubicacion(70.0,93.0))); // casa 1
        casas.add(new Casa(new Ubicacion(250.0,93.0))); // casa 2
        casas.add(new Casa(new Ubicacion(550.0,93.0))); // casa 3
        casas.add(new Casa(residentes.get(1),new Ubicacion(167.0,301.0))); // casa 4
        casas.add(new Casa(new Ubicacion(390.0,301.0))); // casa 5
        escribirCasas(casas);
        
        residentes.get(0).setCasa(casas.get(0));
        residentes.get(1).setCasa(casas.get(3));
        escribirResidentes(residentes);
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        escribirVehiculos(vehiculos);
        
        ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
        escribirVisitantes(visitantes);
        
        //Administrador.enviarCorreo();
 
    }
     
}
