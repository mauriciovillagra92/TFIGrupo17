/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio Alvarez
 */
public class ConexionMySQL 
{
    private static ConexionMySQL instancia = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/laoma";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    private ConexionMySQL()
    {
        
    }
    public static ConexionMySQL getInstancia()
    {
        if(instancia == null)
        {
            instancia = new ConexionMySQL();
        }
        return instancia;
    }
    public Connection getConexion()
    {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: failed to load JDBC driver.");
            e.printStackTrace();
        }
        try {
            return (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
