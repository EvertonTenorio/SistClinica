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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(length = 80, nullable = false)
    private String Nome;
    @Column(length = 15, nullable = false, unique = true)
    private String Cpf;
    @Column(length = 15, nullable = false, unique = true)
    private String Rg;
    @Column(length = 14)
    private String TelefoneFixo;
    @Column(length = 14)
    private String Celular;
    @Column(length = 1)
    private String Genero;
    @Column(length = 15, unique = true)
    private String CRM;
    @ManyToOne
    private Especialidade NomeEspecialidade;
    @Embedded
    private Endereco endereco;

    @Deprecated
    public Medico() {
        endereco= new Endereco();
    }

    public Medico(String Nome, String Cpf, String Rg, Endereco endereco, String TelefoneFixo,
            String Celular, String Genero, String CRM, Especialidade NomeEspecialidade) {
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Rg = Rg;
        this.endereco = endereco;
        this.TelefoneFixo = TelefoneFixo;
        this.Celular = Celular;
        this.Genero = Genero;
        this.CRM = CRM;
        this.NomeEspecialidade = NomeEspecialidade;
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
        this.Cpf = Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
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
}