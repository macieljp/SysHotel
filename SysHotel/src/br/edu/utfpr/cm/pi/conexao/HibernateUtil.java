/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.conexao;

import br.edu.utfpr.cm.pi.modal.Apartamento;
import br.edu.utfpr.cm.pi.modal.Cliente;
import br.edu.utfpr.cm.pi.modal.Endereco;
import br.edu.utfpr.cm.pi.modal.Estado;
import br.edu.utfpr.cm.pi.modal.Fornecedor;
import br.edu.utfpr.cm.pi.modal.GrupoDeProduto;
import br.edu.utfpr.cm.pi.modal.Hospedar;
import br.edu.utfpr.cm.pi.modal.Municipio;
import br.edu.utfpr.cm.pi.modal.Produto;
import br.edu.utfpr.cm.pi.modal.Reserva;
import br.edu.utfpr.cm.pi.modal.Telefone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author a912433
 */
public class HibernateUtil {

    private static AnnotationConfiguration cfg;
    private static SessionFactory sessionFactory;
    private static String pass = "aluno";
    private static String user = "root";

    public static Session openConnect() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/syshotel");
            cfg.setProperty("hibernate.connection.username", user);
            cfg.setProperty("hibernate.connection.password", pass);
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");

            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Municipio.class);
            cfg.addAnnotatedClass(Estado.class);
            cfg.addAnnotatedClass(Telefone.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Fornecedor.class);
            cfg.addAnnotatedClass(GrupoDeProduto.class);
            cfg.addAnnotatedClass(Produto.class);
            cfg.addAnnotatedClass(Reserva.class);
            cfg.addAnnotatedClass(Apartamento.class);
            cfg.addAnnotatedClass(Hospedar.class);


            sessionFactory = cfg.buildSessionFactory();

        }
        return sessionFactory.openSession();
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        HibernateUtil.pass = pass;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        HibernateUtil.user = user;
    }

    public static void criarSchema() {
        openConnect().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }
}