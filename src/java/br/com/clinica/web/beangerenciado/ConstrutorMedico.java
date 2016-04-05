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
 * @author Mayara
 */
@ManagedBean(name = "cmedico")
@ViewScoped
public class ConstrutorMedico {

    private String Nome;
    private String Cpf;
    private Long Rg;
    private Endereco endereco;
    private Long TelefoneFixo;
    private Long Celular;
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
