/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Consulta;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.implementacoes.RepositorioConsultaImplDB;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jackson
 */
@ManagedBean(name="controleConsulta")
@SessionScoped
public class ControladorConsulta {
    private RepositorioConsultaImplDB repositorioConsulta= null;
    private Consulta selectedCons;
    private List<String> ListaHorarios;
    private ControladorLogin controleLogin;
    
    public ControladorConsulta(){
        this.repositorioConsulta= new RepositorioConsultaImplDB();
        this.ListaHorarios = new ArrayList<>();
        this.controleLogin = (ControladorLogin)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("controleLogin");
        if(this.controleLogin==null){
            controleLogin = new ControladorLogin();
            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("controleLogin",this.controleLogin);
        }
    }
    
     public String inserirConsulta(Consulta co){
        this.repositorioConsulta.inserir(co);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "A Consulta foi cadastrada com sucesso!"));
        
        if(controleLogin.getFuncLogado() != null){
            return "/ApresentaConsulta.xhtml";
        }else{
            return "/indexPaciente.xhtml";
        }   
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
    public List<Consulta> recuperarConsultaPac(Paciente p){
      return repositorioConsulta.recuperarConsultasPaciente(p);
    }
    
    public Consulta recuperaConsulta(Long codigo){
        return this.repositorioConsulta.recuperar(codigo);
    }
    public List<Consulta> recuperarConsultasDoDia(){
        return repositorioConsulta.recuperarConsultasData();
    }
    
    public void deletarConsulta(Consulta co){
        this.repositorioConsulta.excluir(co);
    }
    
    public List<Consulta> getConsultas(){
        return this.repositorioConsulta.recuperarTodos();
    }

    public RepositorioConsultaImplDB getRepositorioConsulta() {
        return repositorioConsulta;
    }

    public void setRepositorioConsulta(RepositorioConsultaImplDB repositorioConsulta) {
        this.repositorioConsulta = repositorioConsulta;
    }

    public Consulta getSelectedCons() {
        return selectedCons;
    }

    public void setSelectedCons(Consulta selectedCons) {
        this.selectedCons = selectedCons;
    }

    public List<String> getListaHorarios() {
        return ListaHorarios;
    }

    public void setListaHorarios(List<String> ListaHorarios) {
        this.ListaHorarios = ListaHorarios;
    }
}