/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;


import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.implementacoes.RepositorioPacienteImplDB;
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
@ManagedBean(name="controlePaciente")
@SessionScoped
public class ControladorPaciente {
    
    private RepositorioGenerico<Paciente> repositorioPaciente = null;
    private Paciente selectedPac;
    private ControladorLogin controleFunc;
    
    public ControladorPaciente(){
        this.repositorioPaciente= new RepositorioPacienteImplDB();
    }
    
    public String inserircPaciente(Paciente c){
        if(!c.getGenero().toLowerCase().equals("m")&&!c.getGenero().toLowerCase().equals("f")){
            c.setGenero(c.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", new FacesMessage("problema",
                                                            "O gênero só pode ser"
                                                                 + " M ou F"));
           return null;
        }
        
        
        this.repositorioPaciente.inserir(c);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "O Paciente '"+c.getNome()+""
                        + "' foi cadastrado com sucesso!"));
     
        return "ApresentaPaciente.xhtml";
    }
    
      
    
    public String alterarPaciente(Paciente c){
        if(!c.getGenero().toLowerCase().equals("m")&&!c.getGenero().toLowerCase().equals("f")){
            c.setGenero(c.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", 
                                            new FacesMessage("problema", "O gênero só pode ser"
                                                                            + " M ou F"));
           return null;
        }
         
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "o Paciente '" + c.getNome() + "' foi alterado com sucesso!!"));
         
        this.repositorioPaciente.alterar(c);
        
        return "ApresentaPaciente.xhtml";
       
    }
    
   
    
    public Paciente recuperaPaciente(Long codigo){
        return this.repositorioPaciente.recuperar(codigo);
    }
    
    public void deletarPaciente(Paciente c){
        this.repositorioPaciente.excluir(c);
    }
    
    public List<Paciente> getPacientes(){
        return this.repositorioPaciente.recuperarTodos();
    }

    public RepositorioGenerico<Paciente> getRepositorioPaciente() {
        return repositorioPaciente;
    }

    public void setRepositorioPaciente(RepositorioGenerico<Paciente> repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public Paciente getSelectedPac() {
        return selectedPac;
    }

    public void setSelectedPac(Paciente selectedPac) {
        this.selectedPac = selectedPac;
    }

    public ControladorLogin getControleFunc() {
        return controleFunc;
    }

    public void setControleFunc(ControladorLogin controleFunc) {
        this.controleFunc = controleFunc;
    }

   
    
}
