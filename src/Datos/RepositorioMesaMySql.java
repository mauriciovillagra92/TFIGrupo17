/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 17
 */
public class RepositorioMesaMySql implements IRepositorioMesa
{
    private static RepositorioMesaMySql instancia = null;
    
    private RepositorioMesaMySql()
    {
        
    }
    public static RepositorioMesaMySql getInstancia()
    {
        if(instancia == null)
            return instancia = new RepositorioMesaMySql();
        return instancia;
    }

    @Override
    public int getCantidadMesa() {
        String consulta = "SELECT * from mesa";
        Statement statement;
        int cantidadMesas = 0;

        try {

            statement = ConexionMySQL.getInstancia().getConexion().createStatement();

            ResultSet rs = statement.executeQuery(consulta);

            while (rs.next()) {

                cantidadMesas = rs.getInt("cantidad");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
    }
        return cantidadMesas;
    
}

    @Override
    public void setCantidadMesa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


