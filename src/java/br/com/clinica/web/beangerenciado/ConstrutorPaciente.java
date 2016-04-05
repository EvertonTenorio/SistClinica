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
    private String Cpf;
    private Long Rg;
    private Endereco endereco;
    private Long TelefoneFixo;
    private Long Celular;
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
