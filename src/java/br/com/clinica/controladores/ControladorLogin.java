/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Funcionario;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.implementacoes.RepositorioLoginImplDB;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Everton
 */
@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControladorLogin {

    private Funcionario funcLogado = null;
    private Paciente pacLogado = null;
    private ControladorFuncionario controleFuncionario = null;
    private ControladorPaciente controlePaciente = null;
    private RepositorioLoginImplDB repositorioLogin = null;

    public ControladorLogin() {
        HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(true));

        controleFuncionario = (ControladorFuncionario) session.getAttribute("controleFuncionario");
        controlePaciente = (ControladorPaciente) session.getAttribute("controlePaciente");
        
        if (controleFuncionario == null) {
            controleFuncionario = new ControladorFuncionario();
            session.setAttribute("controleFuncionario", controleFuncionario);
        }
        
        if(controlePaciente == null){
            controlePaciente = new ControladorPaciente();
            session.setAttribute("controlePaciente", controlePaciente);
        }
        repositorioLogin = new RepositorioLoginImplDB();
    }

    public String realizarLogin(String login, String senha) {
        logarFuncionario(login, senha);
        logarPaciente(login, senha);
        
        if ((funcLogado == null) && (pacLogado == null)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema!", "O Usuario não existe!"));
            return "index.xhtml";
        } else if((funcLogado != null) && (pacLogado == null)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns!", "Funcionário logado com sucesso!"));
            return "indexMenu.xhtml";
        }else if((pacLogado != null) && (funcLogado == null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns!", "Paciente logado com sucesso!"));
            return "menuPaciente.xhtml";
        }else{
            return null;
        }
    }
    
    public void logarFuncionario(String login, String senha){
        Funcionario f = null;
        f = repositorioLogin.buscarUsuarioFuncionario(login, senha);
        if(f != null){
            funcLogado = f;
        }
    }
    
    public void logarPaciente(String login, String senha){
        Paciente p = null;
        p = repositorioLogin.buscarUsuarioPaciente(login, senha);
        if(p != null){
            pacLogado = p;
        }
    }
            
    public Funcionario getFuncLogado() {
        return funcLogado;
    }

    public void setFuncLogado(Funcionario funcLogado) {
        this.funcLogado = funcLogado;
    }

    public Paciente getPacLogado() {
        return pacLogado;
    }

    public void setPacLogado(Paciente pacLogado) {
        this.pacLogado = pacLogado;
    }   
}