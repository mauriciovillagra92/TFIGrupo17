/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Main.NegocioEnMemoria;
import Modelo.Mozo;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ignacio Alvarez
 */
public class RepositorioMozoMySql  
{
    private static RepositorioMozoMySql instancia = null;
    
    private RepositorioMozoMySql()
    {
    
    }
    
     public static RepositorioMozoMySql getInstancia()
    {
        if(instancia == null)
            return instancia = new RepositorioMozoMySql();
        return instancia;
    }
     
     public void getMozos() 
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) ConexionMySQL.getInstancia().getConexion().prepareStatement("select * from mozo");

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = (rs.getInt("id"));
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                                            

            }

        } catch (Exception e) {
            System.out.println("Error in getData" + e);
        }
    }
     
     
     public void setCantidadMozo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
