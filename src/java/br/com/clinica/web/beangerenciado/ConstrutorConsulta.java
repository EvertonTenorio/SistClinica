/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;


import br.com.clinica.negocio.Consulta;
import br.com.clinica.negocio.Medico;
import br.com.clinica.negocio.Paciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean(name="cconsulta")
@ViewScoped
public class ConstrutorConsulta {
    
    private Long Id;
    private Paciente Paciente;
    private Medico Medico;
    private Date Data;
    private Long hora;

    public ConstrutorConsulta(){
        this.Data = new Date();
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

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
    
    public void setHoraString(String hora){
        this.hora = Long.parseLong(hora.split(":")[0]);
        
        /*SimpleDateFormat sdf = new SimpleDateFormat("hh");
        sdf.format(Data);*/
    }
    
    public String getHoraString(){
        return this.hora+"";
    }
    
    
    public Consulta construirConsulta(){
        this.Data.setTime(this.Data.getTime()+3600000*hora);
        
        return new Consulta(this.Paciente, this.Medico, this.Data);
    }
}

