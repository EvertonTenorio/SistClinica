/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Medico;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author Mayara
 */
public class RepositorioMedicoImplDB implements RepositorioGenerico<Medico> {

    @Override
    public void inserir(Medico t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Medico t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Medico recuperar(Long codigo) {
        return (Medico)DaoManagerHiber.getInstance().recover("from Medico where Id="+codigo);
    }

    @Override
    public void excluir(Medico t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Medico> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Medico");
    }
    
}
