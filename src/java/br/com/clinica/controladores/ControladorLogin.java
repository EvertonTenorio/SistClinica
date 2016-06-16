/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.controladores;

import br.com.clinica.negocio.Funcionario;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.negocio.Usuario;
import br.com.clinica.repositorio.implementacoes.RepositorioLoginImplDB;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public String realizarLogin(Usuario usuario) throws NoSuchAlgorithmException {
        logarFuncionario(usuario.getEmail(), usuario.getSenha());
        logarPaciente(usuario.getEmail(), usuario.getSenha());
        
        if ((funcLogado == null) && (pacLogado == null)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema!", "O Usuario não existe!"));
            return "/index.xhtml";
        } else if((funcLogado != null) && (pacLogado == null)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns!", "Funcionário "+funcLogado.getNome() +" logado com sucesso!"));
            return "/indexFuncionario.xhtml";
        }else if((pacLogado != null) && (funcLogado == null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns!", "Paciente "+ pacLogado.getNome()+" logado com sucesso!"));
            return "/indexPaciente.xhtml";
        }else{
            return null;
        }
    }
    
    public void logarFuncionario(String login, String senha) throws NoSuchAlgorithmException{
        Funcionario f = null;
        f = repositorioLogin.buscarUsuarioFuncionario(login, converterSenhaMD5(senha));
        if(f != null){
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", f);
            funcLogado = f;
        }else{
            funcLogado = null;
        }
    }
    
    public void logarPaciente(String login, String senha) throws NoSuchAlgorithmException{
        Paciente p = null;
        p = repositorioLogin.buscarUsuarioPaciente(login, converterSenhaMD5(senha));
        if(p != null){
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", p);
            pacLogado = p;
        }else{
            pacLogado = null;
        }
    }
    
    public String sair(){
        this.funcLogado = null;
        this.pacLogado = null;
        ((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true))).removeAttribute("usuario");
        return "/index.xhtml";
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

    public String converterSenhaMD5(String senha) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
 
        return String.format("%32x", hash);
    }
}