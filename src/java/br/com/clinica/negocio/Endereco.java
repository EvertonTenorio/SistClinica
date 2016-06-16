/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 * @author Jackson 
 */
@Embeddable
public class Endereco implements Serializable {
    
    @Column(length = 80, nullable = false)
    private String logradouro;
    @Column(length = 80, nullable = false)
    private String numero;
    @Column(length = 80, nullable = false)
    private String bairro;
    @Column(length = 80, nullable = false)
    private String estado;
    @Column(length = 80, nullable = false)
    private String cidade;
    @Column(length = 80, nullable = false)
    private String cep;

    public Endereco(String logradouro, String numero, String bairro, String estado, String cidade, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Deprecated
    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
