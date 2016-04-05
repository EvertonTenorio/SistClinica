/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Funcionario;
import br.com.clinica.negocio.Paciente;

/**
 *
 * @author Everton
 */
public class RepositorioLoginImplDB {
    
    public Paciente buscarUsuarioPaciente(String email, String senha){
        Paciente usuario;
        
        usuario = (Paciente)DaoManagerHiber.getInstance().recover("from paciente where email=" + email +
                " and senha="+senha);
        
        return usuario;
    }
    
    public Funcionario buscarUsuarioFuncionario(String email, String senha){
        Funcionario usuario;
        
        usuario = (Funcionario)DaoManagerHiber.getInstance().recover("from funcionario where email=" + email +
                " and senha="+senha);
        
        return usuario;
    }
}