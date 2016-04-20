/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Funcionario;
import br.com.clinica.negocio.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everton
 */
public class RepositorioLoginImplDB {
    
    public Paciente buscarUsuarioPaciente(String email, String senha){
        Paciente usuario = null;
        List<Paciente> paciente;
        
        paciente = (List<Paciente>)DaoManagerHiber.getInstance().recover("from Paciente where email='" + email +
                "' and senha='"+senha+"'");
        
        if(paciente.size() > 0){
        usuario = paciente.get(0);    
        }
        
        return usuario;
    }
    
    public Funcionario buscarUsuarioFuncionario(String email, String senha){
        Funcionario usuario = null;
        List<Funcionario> funcionario;
        
        funcionario = (List<Funcionario>) DaoManagerHiber.getInstance().recover("from Funcionario where email='" + email +
                "' and senha='"+senha+"'");
        if(funcionario.size() > 0){
            usuario = funcionario.get(0);
        }
        
        return usuario;
    }
}