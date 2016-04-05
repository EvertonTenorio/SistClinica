/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Medico;
import br.com.clinica.repositorio.implementacoes.RepositorioMedicoImplDB;
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
@ManagedBean(name="controleMedico")
@SessionScoped
public class ControladorMedico {
    
    private RepositorioGenerico<Medico> repositorioMedico= null;
    private Medico selectedMed;
    
    public ControladorMedico(){
        this.repositorioMedico= new RepositorioMedicoImplDB();
    }
    public String inserirMedico(Medico m){
        if(!m.getGenero().toLowerCase().equals("m")&&!m.getGenero().toLowerCase().equals("f")){
            m.setGenero(m.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", new FacesMessage("problema",
                                                            "O gênero só pode ser"
                                                                 + " M ou F"));
           return null;
        }
        
        this.repositorioMedico.inserir(m);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "O Médico "+m.getNome()+""
                        + " foi cadastrado com sucesso!"));
        
        
        return "ApresentaMedico.xhtml";
    }
    
    public String alterarMedico(Medico m){
        if(!m.getGenero().toLowerCase().equals("m")&&!m.getGenero().toLowerCase().equals("f")){
            m.setGenero(m.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", 
                                            new FacesMessage("problema", "O gênero só pode ser"
                                                                            + " M ou F"));
           return null;
        }
         
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "o médico " + m.getNome() + " foi alterado com sucesso!!"));
         
        this.repositorioMedico.alterar(m);
        
        return "ApresentaMedico.xhtml";
       
    }
    
    public Medico recuperaMedico(Long codigo){
        return this.repositorioMedico.recuperar(codigo);
    }
    
    public void deletarMedico(Medico m){
        this.repositorioMedico.excluir(m);
    }
    
    public List<Medico> getMedicos(){
        return this.repositorioMedico.recuperarTodos();
    }

    public RepositorioGenerico<Medico> getRepositorioMedico() {
        return repositorioMedico;
    }

    public void setRepositorioMedico(RepositorioGenerico<Medico> repositorioMedico) {
        this.repositorioMedico = repositorioMedico;
    }

    public Medico getSelectedMed() {
        return selectedMed;
    }

    public void setSelectedMed(Medico selectedMed) {
        this.selectedMed = selectedMed;
    }
    
}
