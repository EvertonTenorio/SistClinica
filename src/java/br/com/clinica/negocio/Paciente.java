/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Everton
 */
@Entity
@Table(name="paciente")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue
    private Integer Id;
    @Column(length = 80, nullable = false)
    private String Nome;
    @Column(length = 11, nullable = false, unique = true)
    private String Cpf;
    @Column(length = 11, nullable = false, unique = true)
    private Long Rg;
    @Column(length = 14)
    private Long TelefoneFixo;
    @Column(length = 14)
    private Long Celular;
    @Column(length = 1)
    private String Genero;

    @Embedded
    private Endereco endereco;
    @Embedded
    private Usuario usuario;
     
    @Deprecated
    public Paciente() {
        endereco= new Endereco();
        usuario = new Usuario();
    }

    public Paciente(Integer Id, String Nome, String Cpf, Long Rg, Endereco endereco, Long TelefoneFixo, Long Celular,
            String Genero, Usuario usuario) {
        this.Id = Id;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Rg = Rg;
        this.endereco = endereco;
        this.TelefoneFixo = TelefoneFixo;
        this.Celular = Celular;
        this.Genero = Genero;
        this.usuario = usuario;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public Long getRg() {
        return Rg;
    }

    public void setRg(Long Rg) {
        this.Rg = Rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getTelefoneFixo() {
        return TelefoneFixo;
    }

    public void setTelefoneFixo(Long TelefoneFixo) {
        this.TelefoneFixo = TelefoneFixo;
    }

    public Long getCelular() {
        return Celular;
    }

    public void setCelular(Long Celular) {
        this.Celular = Celular;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}