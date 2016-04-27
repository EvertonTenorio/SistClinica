/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Jackson
 */
@Entity
@Table(name = "consulta")
public class Consulta  implements Serializable{
    @Id
    @GeneratedValue
    private Long Id;
    @ManyToOne //ou vai ser OneToMany
    private Paciente Paciente;
    @ManyToOne
    private Medico Medico;
    
    private Date Data;

    @Deprecated
    public Consulta() {
    }

    public Consulta(Paciente Paciente, Medico Medico, Date Data) {
        this.Paciente = Paciente;
        this.Medico = Medico;
        this.Data = Data;
    }

    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente Paciente) {
        this.Paciente = Paciente;
    }

    public Medico getMedico() {
        return Medico;
    }

    public void setMedico(Medico Medico) {
        this.Medico = Medico;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    } 
}