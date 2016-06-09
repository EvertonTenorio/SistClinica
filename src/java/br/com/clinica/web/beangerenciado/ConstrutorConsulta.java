/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;

import br.com.clinica.controladores.ControladorLogin;
import br.com.clinica.negocio.Consulta;
import br.com.clinica.negocio.Medico;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.implementacoes.RepositorioConsultaImplDB;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jackson
 */
@ManagedBean(name="cconsulta")
@ViewScoped
public class ConstrutorConsulta implements Serializable{
    
    private Long Id;
    private Paciente Paciente;
    private Medico Medico;
    private Date Data;
    private Long hora;
    private ControladorLogin controladorLogin;
    private List<String> ListaHorarios = null;

    public ConstrutorConsulta(){
        this.Data = new Date();
        this.ListaHorarios = new ArrayList<>();
        this.controladorLogin = (ControladorLogin)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().
                getSession(true)).getAttribute("controleLogin");
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

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
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
    }
    
    public String getHoraString(){
        return this.hora+"";
    }
    
    public void horasDisponiveisConsultas(Date data){
        List<Consulta> consultas = new RepositorioConsultaImplDB().recuperarConsultasMedicoPorData(this.Medico, data);
        List<Consulta> consultasPaciente = new RepositorioConsultaImplDB().recuperarConsultasPacientePorData(this.Paciente, data);
        
        if(!consultasPaciente.isEmpty()){
            for(int i = 0; i < consultasPaciente.size(); i++){
                consultas.add(consultasPaciente.get(i));
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY");
        
        ListaHorarios.clear();
        
        this.ListaHorarios.add("08:00");
        this.ListaHorarios.add("09:00");
        this.ListaHorarios.add("10:00");
        this.ListaHorarios.add("11:00");
        this.ListaHorarios.add("14:00");
        this.ListaHorarios.add("15:00");
        this.ListaHorarios.add("16:00");
        this.ListaHorarios.add("17:00");
    
        int horaAtual = Integer.parseInt(sdf.format(new Date()).split(":")[0]);
        String dataAtual = sdf2.format(new Date());
        
        String horaConsulta;
        boolean removeuHora = false;
        
        for(int j = 0; j < ListaHorarios.size(); j++){
            int horaDisponivel = Integer.parseInt(ListaHorarios.get(j).split(":")[0]);
          
            if(horaDisponivel < horaAtual && dataAtual.equals(sdf2.format(data))){
                ListaHorarios.remove(j);
                removeuHora = true;
                j--;
            }
            for(int i = 0; i < consultas.size(); i++){                     
                horaConsulta = sdf.format(consultas.get(i).getData());
                
                if(removeuHora == true){
                    break;
                }
       
                if(ListaHorarios.get(j).equals(horaConsulta)){
                    ListaHorarios.remove(j);
                    removeuHora = false;
                    break;
                }
            }
        }        
    }
    
    public Consulta construirConsulta(){
        this.Data.setTime(this.Data.getTime() + 3600000 * hora);
        
        if(this.Paciente==null)
            this.Paciente = controladorLogin.getPacLogado();
        
        return new Consulta(this.Paciente, this.Medico, this.Data);
    }
}