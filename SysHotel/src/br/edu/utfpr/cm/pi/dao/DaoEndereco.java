/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Endereco;

/**
 *
 * @author paulo
 */
public class DaoEndereco  extends DaoGenerics<Endereco> {
    
    public DaoEndereco() {
        super.alvo = Endereco.class;
    }
}
