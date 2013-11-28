/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Apartamento;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author JoaoPaulo
 */
public class DaoApartamento extends DaoGenerics<Apartamento> {

    public DaoApartamento() {
        super.alvo = Apartamento.class;
    }

    public List<Apartamento> obterPorDescricao(String descricao) {
        List<Apartamento> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where descricao LIKE '"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }

    public Apartamento obterPorNumero(String numero) {
        Apartamento objeto = null;
        if (numero != null) {
            objeto = (Apartamento) session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where numero = '" + numero + "'").uniqueResult();
        }
        return objeto;
    }
}
