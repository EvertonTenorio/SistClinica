/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.web.beangerenciado;

import br.com.clinica.negocio.Especialidade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean(name="cespecialidade")
@ViewScoped
public class ConstrutorEspecialidade {
    private Long Id;
    private String Nome;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
       
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public Especialidade construirEspecialidade(){
        return new Especialidade(this.Id,this.Nome);
    }
    
}
