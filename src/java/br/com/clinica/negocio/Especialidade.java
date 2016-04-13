/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jackson
 */
@Entity
@Table(name = "especialidade")
public class Especialidade implements Serializable{
    @Id
    @GeneratedValue
    private Long Id;
    @Column(length = 50, nullable = false, unique = true)
    private String Nome;

    @Deprecated
    public Especialidade() {
    }

    public Especialidade(Long Id, String Nome) {
        this.Id = Id;
        this.Nome = Nome;
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
    
}
