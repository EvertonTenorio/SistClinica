/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Especialidade;
import br.com.clinica.repositorio.implementacoes.RepositorioEspecialidadeImplDB;
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
@ManagedBean(name="controleEspecialidade")
@SessionScoped
public class ControladorEspecialidade {
    private RepositorioGenerico<Especialidade> repositorioEspecialidade = null;
    private Especialidade selectedEspec;
    
    
    public ControladorEspecialidade(){
        this.repositorioEspecialidade = new RepositorioEspecialidadeImplDB();
    }
    public String inserirEspecialidade(Especialidade e){
        this.repositorioEspecialidade.inserir(e);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "A Especialidade '"+e.getNome()+"'"
                        + " foi cadastrada com sucesso!"));
        
        
        return "ApresentaEspecialidade.xhtml";
    }
    
    public String alterarEspecialidade(Especialidade e){
        
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "A Especialidade '" + e.getNome() + "' foi alterada com sucesso!!"));
         
        this.repositorioEspecialidade.alterar(e);
        
        return "ApresentaEspecialidade.xhtml";
       
    }
    
    public Especialidade recuperaEspecialidade(Long codigo){
        return this.repositorioEspecialidade.recuperar(codigo);
    }
    
    public void deletarEspecialidade(Especialidade e){
        this.repositorioEspecialidade.excluir(e);
    }
    
    public List<Especialidade> getEspecialidades(){
        return this.repositorioEspecialidade.recuperarTodos();
    }

    public RepositorioGenerico<Especialidade> getRepositorioEspecialidade() {
        return repositorioEspecialidade;
    }

    public void setRepositorioEspecialidade(RepositorioGenerico<Especialidade> repositorioEspecialidade) {
        this.repositorioEspecialidade = repositorioEspecialidade;
    }

    public Especialidade getSelectedEspec() {
        return selectedEspec;
    }

    public void setSelectedEspec(Especialidade selectedEspec) {
    
        this.selectedEspec = selectedEspec;
    }
    
}
