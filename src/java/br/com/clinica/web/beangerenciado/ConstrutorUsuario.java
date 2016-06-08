/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;

import br.com.clinica.negocio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Everton
 */
@ManagedBean(name="cusuario")
@RequestScoped
public class ConstrutorUsuario {
    private String Email;
    private String Senha;

    public ConstrutorUsuario() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    public Usuario construirUsuario(){
        return new Usuario(this.Email, this.Senha);
    }
}