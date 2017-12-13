/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Main.Negocio;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 17
 */
public class RepositorioProductosMySql 
{
    private Negocio neg;
    private static RepositorioProductosMySql instancia = null;
    
    private RepositorioProductosMySql()
    {
        
    }
    public static RepositorioProductosMySql getInstancia()
    {
        if(instancia == null)
            return instancia = new RepositorioProductosMySql();
        return instancia;
    }

    public void getTodosProducto() 
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) ConexionMySQL.getInstancia().getConexion().prepareStatement("select * from producto");

            rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = Integer.valueOf(rs.getString("ProductoID"));
                String descripcion = rs.getString("Descproducto");
                double precio = Double.valueOf(rs.getString("precioUnitario"));
                boolean esAgregado = Boolean.valueOf(rs.getString("esAgregado"));
                
                //neg.agregarProducto(new Producto(idProducto,descripcion,precio,esAgregado));
            }

        } catch (Exception e) {
            System.out.println("Error in getData" + e);
        }
    }

    
    public void insert(Producto product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void update(Producto product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Producto buscarProducto(Integer id)
     {
        String consulta = "SELECT * from producto where id == "+String.valueOf(id);
        Statement statement;

        try {

            statement = ConexionMySQL.getInstancia().getConexion().createStatement();

            ResultSet rs = statement.executeQuery(consulta);

            while (rs.next()) {

                int idProducto = Integer.valueOf(rs.getString("id"));
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                boolean esAgregado = Boolean.valueOf("esAgregado");
                Producto producto = new Producto(idProducto, descripcion, precio, esAgregado);
                return producto;
            }


        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        
        
        return null;
    }
    
    
}
