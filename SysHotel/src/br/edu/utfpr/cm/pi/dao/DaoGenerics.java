package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.conexao.TransactionUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author JoaoPaulo
 */
public abstract class DaoGenerics<T> {

  protected Session session = TransactionUtil.getCurrentSession();
    protected Class alvo;

    public void persistir(T o) {
        session.saveOrUpdate(o);
        session.flush();
    }

    public void remover(T o) {
        session.delete(o);
        session.flush();
    }

    public T obterPorId(int id) {
        T objeto = null;
        if (id > 0) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where id = " + id);
            objeto = (T) select.uniqueResult();
        }
        return objeto;
    }

    public List<T> listar() {
        List<T> lista = null;        
        Query query = session.createQuery("FROM " + alvo.getSimpleName());
        lista = query.list();        
        return lista;
    }
}