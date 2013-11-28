/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.conexao;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JoaoPaulo
 */
public class TransactionUtil {
    
    static Session session = null;
    static Transaction transaction = null;
    
    public static void beginTransaction(){
        if(transaction != null){
            throw new RuntimeException("Já existe uma transação iniciada.");
        }else{
            
        session = HibernateUtil.openConnect();
        transaction = session.beginTransaction();        
        }
    }
    
    public static void commit(){
        if(transaction == null){
            throw new RuntimeException("Erro tentando executar commit() sem antes ter executado beginTrans()..");
            
        }
        transaction.commit();
        closeCurrentSession();
        
    }
    
    public static void rollback(){
        if(transaction == null){
            throw new RuntimeException("Erro tentando executar rollback() sem antes ter executado beginTrans()..");
        }
        transaction.rollback();        
        closeCurrentSession();
    }
    
    public static Session getCurrentSession(){
        /*Automatizando a criação da transação.*/
        if(session == null){
            Session session2 = HibernateUtil.openConnect();           
           // System.out.println("========================="+session2.getFlushMode());
            session2.setFlushMode(FlushMode.ALWAYS);            
            return session2; 
        }
        return session;        
    }
    
    
    public  static void closeCurrentSession(){
        session.flush();
        session.close();
        transaction = null;
        session = null;
    }  
    
}
