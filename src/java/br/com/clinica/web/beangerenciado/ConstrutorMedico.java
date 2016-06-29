/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;

import br.com.clinica.negocio.Endereco;
import br.com.clinica.negocio.Especialidade;
import br.com.clinica.negocio.Medico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean(name = "cmedico")
@ViewScoped
public class ConstrutorMedico {

    private String Nome;
    private Long Cpf;
    private Long Rg;
    private Endereco endereco;
    private String TelefoneFixo;
    private String Celular;
    private String Genero;
    private String CRM;
    private Especialidade NomeEspecialidade;
    
    public ConstrutorMedico(){
        this.endereco=new Endereco();
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

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Especialidade getNomeEspecialidade() {
        return NomeEspecialidade;
    }

    public void setNomeEspecialidade(Especialidade NomeEspecialidade) {
        this.NomeEspecialidade = NomeEspecialidade;
    }

    public Medico construirMedico() {
        return new Medico(this.Nome, this.Cpf, this.Rg, this.endereco,
                this.TelefoneFixo, this.Celular, this.Genero,
                this.CRM, this.NomeEspecialidade);
    }
}
