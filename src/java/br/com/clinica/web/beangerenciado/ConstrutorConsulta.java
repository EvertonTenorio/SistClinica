/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;


import br.com.clinica.negocio.Consulta;
import br.com.clinica.negocio.Medico;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.implementacoes.RepositorioConsultaImplDB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.joda.time.DateTime;

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
    private DateTime Data;
    private Long hora;
    private List<String> ListaHorarios;

    public ConstrutorConsulta(){
        this.Data = new DateTime();
        this.ListaHorarios = new ArrayList<>();
    }

    public List<String> getListaHorarios() {
        return ListaHorarios;
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

    public DateTime getData() {
        return Data;
    }

    public void setData(DateTime Data) {
        this.Data = Data;
        this.horasDisponiveisConsultas(this.Data);
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
    
    public void horasDisponiveisConsultas(DateTime data){
        List<Consulta> consultas = new RepositorioConsultaImplDB().recuperarConsultasMedico(this.Medico, data);
        
        for (int i = 0; i < consultas.size(); i++) {
          consultas.remove(i);
        }
        
        if(consultas.isEmpty()){
            this.ListaHorarios.add("08:00");
            this.ListaHorarios.add("09:00");
            this.ListaHorarios.add("10:00");
            this.ListaHorarios.add("11:00");
            this.ListaHorarios.add("14:00");
            this.ListaHorarios.add("15:00");
            this.ListaHorarios.add("16:00");
            this.ListaHorarios.add("17:00");
        }
        
        for(Consulta c : consultas){
            if(c.getData().getHourOfDay() != 8){
                this.ListaHorarios.add("08:00");
            }
            if(c.getData().getHourOfDay() != 9){
                this.ListaHorarios.add("09:00");
            }
            if(c.getData().getHourOfDay() != 10){
                this.ListaHorarios.add("10:00");
            }
            if(c.getData().getHourOfDay() != 11){
                this.ListaHorarios.add("11:00");
            }
            if(c.getData().getHourOfDay() != 14){
                this.ListaHorarios.add("14:00");
            }
            if(c.getData().getHourOfDay() != 15){
                this.ListaHorarios.add("15:00");
            }
            if(c.getData().getHourOfDay() != 16){
                this.ListaHorarios.add("16:00");
            }
            if(c.getData().getHourOfDay() != 17){
                this.ListaHorarios.add("17:00");
            }
        }
            
    }
    
    public Consulta construirConsulta(){
        this.Data.toDate().setTime(this.Data.getMillis() + 3600000 * hora);
        
        return new Consulta(this.Paciente, this.Medico, this.Data);
    }
}

