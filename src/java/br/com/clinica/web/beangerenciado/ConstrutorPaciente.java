/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;


import br.com.clinica.negocio.Endereco;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.negocio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean(name = "cpaciente")
@ViewScoped
public class ConstrutorPaciente {

    private Integer Id;
    private String Nome;
    private Long Cpf;
    private Long Rg;
    private Endereco endereco;
    private String TelefoneFixo;
    private String Celular;
    private String Genero;
    private Usuario usuario;

    public ConstrutorPaciente(){
        this.endereco=new Endereco();
        this.usuario = new Usuario();
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
    
    public Paciente construirPaciente() {
        return new Paciente(this.Id, this.Nome, this.Cpf, this.Rg,
                this.endereco, this.TelefoneFixo, this.Celular, this.Genero, this.usuario);
    }

}
