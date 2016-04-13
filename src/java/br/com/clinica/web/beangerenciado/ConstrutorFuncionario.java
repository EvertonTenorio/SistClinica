/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;

import br.com.clinica.negocio.Endereco;
import br.com.clinica.negocio.Funcionario;
import br.com.clinica.negocio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean(name = "cfuncionario")
@RequestScoped
public class ConstrutorFuncionario {

    private Long Id;
    private String Nome;
    private Long Cpf;
    private Long Rg;
    private Endereco endereco;
    private String TelefoneFixo;
    private String Celular;
    private Double Salario;
    private String Genero;
    private Usuario usuario;

      public ConstrutorFuncionario(){
        this.endereco=new Endereco();
        this.usuario = new Usuario();
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
    
    public Funcionario construirFuncionario() {
        return new Funcionario(this.Id, this.Nome, this.Cpf, this.Rg,
                this.endereco, this.TelefoneFixo,
                this.Celular, this.Salario, this.Genero, this.usuario);
    }
}