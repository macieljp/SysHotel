/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Municipio;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author JoaoPaulo
 */
public class DaoMunicipio extends DaoGenerics<Municipio> {

    public DaoMunicipio() {
        super.alvo = Municipio.class;
    }
    
    
    public List<Municipio> obterNome(String nome) {
        List<Municipio> lista = null;
        if (nome != null || !"".equals(nome)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where nome LIKE '%"
                    + nome + "%'");
            lista = query.list();
        }
        return lista;
    }

    public Municipio obterId(String id) {
        Municipio objeto = null;
        if (id != null) {
            objeto = (Municipio) session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where id = '" + id + "'").uniqueResult();
        }
        return objeto;
    }
}
