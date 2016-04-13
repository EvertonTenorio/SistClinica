package br.com.clinica.primefaces;


import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Consulta;
import br.com.clinica.repositorio.implementacoes.RepositorioConsultaImplDB;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;



import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;

import org.primefaces.model.chart.DateAxis;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jackson
 */

@ManagedBean
@javax.faces.bean.ViewScoped
public class ChartView implements Serializable {
 
   private BarChartModel lineModel1;
   
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public BarChartModel getLineModel1() {
        return lineModel1;
    }
 
   
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Relatório");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        
         
        
    }
     
   
    private BarChartModel initLinearModel() {
        
        BarChartModel model = new BarChartModel();
        ChartSeries series1 = new ChartSeries();
        series1.setLabel("Quantidade de Consultas");
        
        Consulta consulta=null;
        Date data = null;
       
        RepositorioGenerico<Consulta> repositorioConsulta= new RepositorioConsultaImplDB();
        List<Consulta> consultas = repositorioConsulta.recuperarTodos();
    
        series1.setLabel("Consultas");
        series1.set("Janeiro", 2);
        series1.set("Fevereiro", 1);
        series1.set("Março", 3);
        series1.set("Abril", 6);
        series1.set("Maio", 8);
        series1.set("Junho", 2);
        series1.set("Julho", 1);
        series1.set("Agosto", 3);
        series1.set("Setembro", 6);
        series1.set("Outubro", 8);
        series1.set("Novembro", 6);
        series1.set("Dezembro", 8);
 
        model.addSeries(series1);
        
         
        return model;
        
        
    }
     
  
 
 
}
