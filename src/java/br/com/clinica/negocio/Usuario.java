/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Everton
 */

@Embeddable
public class Usuario implements Serializable{

    @Column(length = 80, nullable = false, unique = true)
    private String Email;
    @Column(length = 80, nullable = false)
    private String Senha;

    public Usuario(String Email, String Senha) {
        this.Email = Email;
        this.Senha = Senha;
    }
    
    @Deprecated
    public Usuario(){
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
}