/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Produto;

/**
 *
 * @author a1208195
 */
public class DaoProduto extends DaoGenerics<Produto> {

    public DaoProduto() {
        super.alvo = Produto.class;
    }
}
