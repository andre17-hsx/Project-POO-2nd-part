/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaReportesController implements Initializable {

    @FXML
    private MenuItem btnMapa;
    @FXML
    private Pane paneGrafico1;
    @FXML
    private Pane paneGrafico2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarGraficos();
    }    

    @FXML
    private void mostrarMapa(ActionEvent event) {
         try{
                            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaAdministrador.fxml"));
            
                            Parent root = loader.load();
                            VistaAdministradorController ic = loader.<VistaAdministradorController>getController();
                            System.out.println(ic);
                            App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }
    
    
    private void cargarGraficos(){
    graficoIngresoHora();
    graficoResidentesVsVisitantes();
    }
    
    private void graficoIngresoHora(){
        CategoryAxis x = new CategoryAxis();
        x.setLabel("HORAS");  
        NumberAxis y = new NumberAxis();
        y.setLabel("INGRESOS");
        
        BarChart bc = new BarChart(x, y);
        bc.setTitle("INGRESO POR HORAS DE RESIDENTES Y VISITANTES");
        
        XYChart.Series rs = new XYChart.Series();
        rs.setName("RESIDENTES");
        rs.getData().add(new XYChart.Data("00-01", 33));
        rs.getData().add(new XYChart.Data("01:02", 25));
        rs.getData().add(new XYChart.Data("02-03", 10));
        rs.getData().add(new XYChart.Data("03-04", 10));
        rs.getData().add(new XYChart.Data("04-05", 11));
        rs.getData().add(new XYChart.Data("05-06", 20));
        rs.getData().add(new XYChart.Data("06-07", 10));
        rs.getData().add(new XYChart.Data("07-08", 10));
        rs.getData().add(new XYChart.Data("08-09", 10));
        rs.getData().add(new XYChart.Data("09-10", 1));
        rs.getData().add(new XYChart.Data("10-11", 10));
        rs.getData().add(new XYChart.Data("11-12", 10));
        rs.getData().add(new XYChart.Data("12-13", 10));
        rs.getData().add(new XYChart.Data("13-14", 10));
        rs.getData().add(new XYChart.Data("14-15", 10));
        rs.getData().add(new XYChart.Data("15-16", 10));
        rs.getData().add(new XYChart.Data("16-17", 10));
        rs.getData().add(new XYChart.Data("17-18", 10));
        rs.getData().add(new XYChart.Data("18-19", 10));
        rs.getData().add(new XYChart.Data("19-20", 10));
        rs.getData().add(new XYChart.Data("20-21", 10));
        rs.getData().add(new XYChart.Data("21-22", 10));
        rs.getData().add(new XYChart.Data("22-23", 10));
        rs.getData().add(new XYChart.Data("23-00", 10));
       
        
        XYChart.Series vs = new XYChart.Series();
        vs.setName("VISITANTES");
        vs.getData().add(new XYChart.Data("00-01", 33));
        vs.getData().add(new XYChart.Data("01:02", 25));
        vs.getData().add(new XYChart.Data("02-03", 10));
        vs.getData().add(new XYChart.Data("03-04", 10));
        vs.getData().add(new XYChart.Data("04-05", 11));
        vs.getData().add(new XYChart.Data("05-06", 20));
        vs.getData().add(new XYChart.Data("06-07", 10));
        vs.getData().add(new XYChart.Data("07-08", 10));
        vs.getData().add(new XYChart.Data("08-09", 10));
        vs.getData().add(new XYChart.Data("09-10", 1));
        vs.getData().add(new XYChart.Data("10-11", 10));
        vs.getData().add(new XYChart.Data("11-12", 10));
        vs.getData().add(new XYChart.Data("13-14", 10));
        vs.getData().add(new XYChart.Data("14-15", 10));
        vs.getData().add(new XYChart.Data("15-16", 10));
        vs.getData().add(new XYChart.Data("16-17", 10));
        vs.getData().add(new XYChart.Data("17-18", 10));
        vs.getData().add(new XYChart.Data("18-19", 10));
        vs.getData().add(new XYChart.Data("19-20", 10));
        vs.getData().add(new XYChart.Data("20-21", 10));
        vs.getData().add(new XYChart.Data("21-22", 10));
        vs.getData().add(new XYChart.Data("22-23", 10));
        vs.getData().add(new XYChart.Data("23-00", 10));
        bc.setPrefWidth(651);
        bc.setPrefHeight(300);
        
        bc.getData().addAll(rs,vs);
        paneGrafico1.getChildren().addAll(bc);

    }
    
    private void graficoResidentesVsVisitantes(){
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("HORAS");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("MONITOREO DE INGRESOS RESIDENTES vs VISITANTES");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("RESIDENTES");
        
        series1.getData().add(new XYChart.Data("1", 23));
        series1.getData().add(new XYChart.Data("2", 14));
        series1.getData().add(new XYChart.Data("3", 15));
        series1.getData().add(new XYChart.Data("4", 24));
        series1.getData().add(new XYChart.Data("5", 34));
        series1.getData().add(new XYChart.Data("6", 36));
        series1.getData().add(new XYChart.Data("7", 22));
        series1.getData().add(new XYChart.Data("8", 25));
        series1.getData().add(new XYChart.Data("9", 13));
        series1.getData().add(new XYChart.Data("10", 17));
        series1.getData().add(new XYChart.Data("11", 29));
        series1.getData().add(new XYChart.Data("12", 25));
        series1.getData().add(new XYChart.Data("13", 23));
        series1.getData().add(new XYChart.Data("14", 14));
        series1.getData().add(new XYChart.Data("15", 15));
        series1.getData().add(new XYChart.Data("16", 24));
        series1.getData().add(new XYChart.Data("17", 34));
        series1.getData().add(new XYChart.Data("18", 36));
        series1.getData().add(new XYChart.Data("19", 22));
        series1.getData().add(new XYChart.Data("20", 15));
        series1.getData().add(new XYChart.Data("21", 13));
        series1.getData().add(new XYChart.Data("22", 17));
        series1.getData().add(new XYChart.Data("23", 29));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data("1", 1));
        series2.getData().add(new XYChart.Data("2", 10));
        series2.getData().add(new XYChart.Data("3", 1));
        series2.getData().add(new XYChart.Data("4", 24));
        series2.getData().add(new XYChart.Data("5", 31));
        series2.getData().add(new XYChart.Data("6", 10));
        series2.getData().add(new XYChart.Data("7", 22));
        series2.getData().add(new XYChart.Data("8", 1));
        series2.getData().add(new XYChart.Data("9", 13));
        series2.getData().add(new XYChart.Data("10", 17));
        series2.getData().add(new XYChart.Data("11", 20));
        series2.getData().add(new XYChart.Data("12", 21));
        series2.getData().add(new XYChart.Data("13", 23));
        series2.getData().add(new XYChart.Data("14", 14));
        series2.getData().add(new XYChart.Data("15", 15));
        series2.getData().add(new XYChart.Data("16", 24));
        series2.getData().add(new XYChart.Data("17", 14));
        series2.getData().add(new XYChart.Data("18", 16));
        series2.getData().add(new XYChart.Data("19", 17));
        series2.getData().add(new XYChart.Data("20", 4));
        series2.getData().add(new XYChart.Data("21", 21));
        series2.getData().add(new XYChart.Data("22", 17));
        series2.getData().add(new XYChart.Data("23", 19));

        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2);
        lineChart.setPrefWidth(651);
        lineChart.setPrefHeight(300);
        paneGrafico2.getChildren().add(lineChart);
    }
    
    
}
