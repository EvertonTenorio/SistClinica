/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Especialidade;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class RepositorioEspecialidadeImplDB implements RepositorioGenerico<Especialidade> {

    @Override
    public void inserir(Especialidade t) {
         DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Especialidade t) {
       DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Especialidade recuperar(Long codigo) {
        return (Especialidade)DaoManagerHiber.getInstance().recover("from Especialidade where Id="+codigo);
    }

    @Override
    public void excluir(Especialidade t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Especialidade> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Especialidade");
    }
    
}
