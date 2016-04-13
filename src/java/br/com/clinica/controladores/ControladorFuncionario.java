/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;


import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import br.com.clinica.repositorio.implementacoes.RepositorioFuncionarioImplDB;
import br.com.clinica.negocio.Funcionario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jackson
 */

@ManagedBean(name = "controleFuncionario")
@SessionScoped
public class ControladorFuncionario {
    
    private RepositorioGenerico<Funcionario> repositorioFuncionario = null;
    private Funcionario selectedFunc;
    
    public ControladorFuncionario(){
        this.repositorioFuncionario = new RepositorioFuncionarioImplDB();
    }
    
    public String inserirFuncionario(Funcionario f){
        
        if(!f.getGenero().toLowerCase().equals("m")&&!f.getGenero().toLowerCase().equals("f")){
            f.setGenero(f.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", new FacesMessage("problema",
                                                            "O gênero só pode ser"
                                                                 + " M ou F"));
           return null;
        }
        
        this.repositorioFuncionario.inserir(f);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("parabéns", "O Funcionário '" +f.getNome()+ "' foi cadastrado com sucesso!"));
        
        return "ApresentaFuncionario.xhtml";
    }
    
    public String alterarFuncionario(Funcionario f){
        if(!f.getGenero().toLowerCase().equals("m")&&!f.getGenero().toLowerCase().equals("f")){
            f.setGenero(f.getGenero().toUpperCase());
            FacesContext.getCurrentInstance().addMessage("form:inputGenero", new FacesMessage("problema", "O gênero só pode ser"
                   + " M ou F"));
           return null;
        }
         
         FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso", "o funcionário '" + f.getNome() + "' foi alterado com sucesso!!"));
         
        this.repositorioFuncionario.alterar(f);
        
        return "ApresentaFuncionario.xhtml";
       
    }
    
    public Funcionario recuperaFuncionario(Long codigo){
        return this.repositorioFuncionario.recuperar(codigo);
    }
    
    public void deletarFuncionario(Funcionario f){
        this.repositorioFuncionario.excluir(f);
    }
    
    public List<Funcionario> getFuncionarios(){
        return this.repositorioFuncionario.recuperarTodos();
    }

    public RepositorioGenerico<Funcionario> getRepositorioFuncionario() {
        return repositorioFuncionario;
    }

    public void setRepositorioFuncionario(RepositorioGenerico<Funcionario> repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public Funcionario getSelectedFunc() {
        return selectedFunc;
    }

    public void setSelectedFunc(Funcionario selectedFunc) {
        this.selectedFunc = selectedFunc;
    }   
}