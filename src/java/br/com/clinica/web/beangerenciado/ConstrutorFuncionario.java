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
 * @author Mayara
 */
@ManagedBean(name = "cfuncionario")
@RequestScoped
public class ConstrutorFuncionario {

    private Long Id;
    private String Nome;
    private String Cpf;
    private Long Rg;
    private Endereco endereco;
    private Long TelefoneFixo;
    private Long Celular;
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

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        Cpf = Cpf.trim();

        for (int i = Cpf.length() - 1; i < 10; i++) {
            Cpf = "0" + Cpf;
        }
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