/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Consulta;
import br.com.clinica.negocio.Medico;
import br.com.clinica.negocio.Paciente;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class RepositorioConsultaImplDB implements RepositorioGenerico<Consulta> {

    @Override
    public void inserir(Consulta t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Consulta t) {
        DaoManagerHiber.getInstance().update(t);
    }

   @Override
    public Consulta recuperar(Long codigo) {
        return (Consulta)DaoManagerHiber.getInstance().recover("from Consulta where Id="+codigo);
    }

    @Override
    public void excluir(Consulta t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Consulta> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Consulta");
    }
  
    public List<Consulta> recuperarConsultasMedico(Medico m, Date data){
        
       List<Consulta> consultas = DaoManagerHiber.getInstance().recover("from Consulta where Medico_Id = "+ m.getId());
     
        if(consultas==null)
           return null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayKey = sdf.format(data);
        
        for(Iterator<Consulta> c = consultas.iterator();c.hasNext();){
            Consulta caux = c.next();
            String d = sdf.format(caux.getData());
            if(!d.equals(dayKey)){
                c.remove();
            }
        }        
            
        return consultas;
       // String dataformatada = sdf.format(data);
       // return (List<Consulta>) DaoManagerHiber.getInstance().recoverSQL("select * from consulta where Medico_Id = "+ m.getId() +" and CAST(Data as Date) = '"+dataformatada+"';");
    }
    
    public List<Consulta> recuperarConsultasPaciente(Paciente p, Date data){
        List<Consulta> consultas = DaoManagerHiber.getInstance().recover("from Consulta where Paciente_Id = "+ p.getId());
     
        if(consultas==null)
           return null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayKey = sdf.format(data);
        
        for(Iterator<Consulta> c = consultas.iterator();c.hasNext();){
            Consulta caux = c.next();
            String d = sdf.format(caux.getData());
            if(!d.equals(dayKey)){
                c.remove();
            }
        }        
            
        return consultas;
    }
}