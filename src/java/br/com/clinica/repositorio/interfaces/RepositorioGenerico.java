/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.repositorio.interfaces;

import java.util.List;

/**
 *
 * @author Jackson
 */
public interface RepositorioGenerico <T> {
    
    public void inserir(T t);
    public void alterar(T t);
    public T recuperar(Long codigo);
    public void excluir(T t);
    public List<T> recuperarTodos(); 
}
