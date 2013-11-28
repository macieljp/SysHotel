/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Fornecedor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author JoaoPaulo
 */
public class DaoFornecedor extends DaoGenerics<Fornecedor> {

    public DaoFornecedor() {
        super.alvo = Fornecedor.class;
    }

    public List<Fornecedor> obterNome(String nome) {

        List<Fornecedor> lista = null;
        if (nome != null || !"".equals(nome)) {

            Query query = session.createQuery("From " + alvo.getSimpleName()
                    + " where nome LIKE '"
                    + nome + "%'");
            lista = query.list();
        }
        return lista;
    }
}
