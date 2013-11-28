/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static java.sql.Connection conexao = null;
    private static com.mysql.jdbc.Driver mysqlDriver;

    public static java.sql.Connection getConnection() throws SQLException {
        String conecaoMysql = "jdbc:mysql://localhost" + "/?user=" + HibernateUtil.getUser()
                + "&password=" + HibernateUtil.getPass();
        if (conexao == null) {
            mysqlDriver = new com.mysql.jdbc.Driver();
            conexao = DriverManager.getConnection(conecaoMysql);
        }
        return conexao;
    }
}
