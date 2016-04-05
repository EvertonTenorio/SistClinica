/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.implementacoes;

import br.com.clinica.dao.DaoManagerHiber;
import br.com.clinica.negocio.Funcionario;
import br.com.clinica.repositorio.interfaces.RepositorioGenerico;
import java.util.List;



/**
 *
 * @author Mayara
 */
public class RepositorioFuncionarioImplDB implements RepositorioGenerico<Funcionario>{

    @Override
    public void inserir(Funcionario f) {
        DaoManagerHiber.getInstance().persist(f);
    }

    @Override
    public void alterar(Funcionario f) {
        DaoManagerHiber.getInstance().update(f);
    }

    @Override
    public Funcionario recuperar(Long codigo) {
        return (Funcionario)DaoManagerHiber.getInstance().recover("from Funcionario where Id="+codigo);
    }

    @Override
    public void excluir(Funcionario f) {
        DaoManagerHiber.getInstance().delete(f);
    }

    @Override
    public List<Funcionario> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Funcionario");
    }
    
}