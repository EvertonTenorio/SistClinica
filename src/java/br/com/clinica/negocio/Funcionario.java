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
 * @author Jackson
 */
@Entity
@Table(name = "funcionario")
public class Funcionario  implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;
    @Column(length = 80, nullable = false)
    private String Nome;
    @Column(length = 11, nullable = false, unique = true)
    private Long Cpf;
    @Column(length = 11, nullable = false, unique = true)
    private Long Rg;
    @Column(length = 25)
    private String TelefoneFixo;
    @Column(length = 25)
    private String Celular;
    @Column(length = 7)
    private Double Salario;
    @Column(length = 15)
    private String Genero;
    @Embedded
    private Endereco endereco;
    @Embedded
    private Usuario usuario;

    @Deprecated
    public Funcionario() {
        endereco= new Endereco();
        usuario = new Usuario();
    }

    public Funcionario(Long Id, String Nome, Long Cpf, Long Rg, Endereco endereco, String TelefoneFixo, String Celular,
            Double Salario, String Genero, Usuario usuario) {

        this.Id = Id;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Rg = Rg;
        this.endereco = endereco;
        this.TelefoneFixo = TelefoneFixo;
        this.Celular = Celular;
        this.Salario = Salario;
        this.Genero = Genero;
        this.usuario = usuario;
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Long getCpf() {
        return Cpf;
    }

    public void setCpf(Long Cpf) {
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

    public String getTelefoneFixo() {
        return TelefoneFixo;
    }

    public void setTelefoneFixo(String TelefoneFixo) {
        this.TelefoneFixo = TelefoneFixo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
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
