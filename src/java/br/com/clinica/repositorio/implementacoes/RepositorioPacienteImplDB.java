
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Paciente;

import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class RepositorioPacienteImplDB implements RepositorioGenerico<Paciente> {

   

    @Override
    public void inserir(Paciente t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Paciente t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Paciente recuperar(Long codigo) {
        return (Paciente)DaoManagerHiber.getInstance().recover("from Paciente where Id="+codigo);
    }

    @Override
    public void excluir(Paciente t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Paciente> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Paciente");
    }
    
}
