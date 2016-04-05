/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Consulta;
import br.com.clinica.repositorio.implementacoes.RepositorioConsultaImplDB;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mayara
 */
@ManagedBean(name="controleConsulta")
@SessionScoped
public class ControladorConsulta {
    private RepositorioGenerico<Consulta> repositorioConsulta= null;
    private Consulta selectedCons;
    
    public ControladorConsulta(){
        this.repositorioConsulta= new RepositorioConsultaImplDB();
    }
    
     public String inserirConsulta(Consulta co){
        this.repositorioConsulta.inserir(co);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "A Consulta foi cadastrada com sucesso!"));
        
        
        return "ApresentaConsulta.xhtml";
    }
    
     public String inserirConsultaFunc(Consulta co){
        this.repositorioConsulta.inserir(co);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "A Consulta foi cadastrada com sucesso!"));
        
        
        return "ApresentaConsultaFuncionario.xhtml";
    }
    
    public String alterarConsulta(Consulta co){
        
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "A consulta foi alterada com sucesso!!"));
         
        this.repositorioConsulta.alterar(co);
        
        return "ApresentaConsulta.xhtml";
       
    }
    
    public String alterarConsultaFunc(Consulta co){
        
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "A consulta foi alterada com sucesso!!"));
         
        this.repositorioConsulta.alterar(co);
        
        return "ApresentaConsultaFuncionario.xhtml";
       
    }
    
    public Consulta recuperaConsulta(Long codigo){
        return this.repositorioConsulta.recuperar(codigo);
    }
    
    public void deletarConsulta(Consulta co){
        this.repositorioConsulta.excluir(co);
    }
    
    public List<Consulta> getConsultas(){
        return this.repositorioConsulta.recuperarTodos();
    }

    public RepositorioGenerico<Consulta> getRepositorioConsulta() {
        return repositorioConsulta;
    }

    public void setRepositorioConsulta(RepositorioGenerico<Consulta> repositorioConsulta) {
        this.repositorioConsulta = repositorioConsulta;
    }

    public Consulta getSelectedCons() {
        return selectedCons;
    }

    public void setSelectedCons(Consulta selectedCons) {
        this.selectedCons = selectedCons;
    }
    
}