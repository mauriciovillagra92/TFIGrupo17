/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Main.Negocio;
import Main.NegocioEnMemoria;
import Modelo.Mesa;
import Modelo.Mozo;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class NegocioMySQL implements Negocio {

    @Override
    public Mesa getMesa(int numero) {
        ArrayList<Mesa> mesas = getListaMesas();
        for(Mesa m: mesas)
        {
        if(m.getNumero() == numero)
                return m;
        }
        return null;
        
    }

    @Override
    public Mozo getMozo(int numero) {
        ArrayList<Mozo> mozos = getListaMozos();
        for(Mozo m: mozos)
        {
            if(m.getId() == numero)
                return m;
        }
        return null;
    }

    @Override
    public Producto buscarProducto(int id) {
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
    

   /* @Override
    public ArrayList<Producto> filtrarCatalogo(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public ArrayList<Mesa> getListaMesas() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        try
        {
            ps = (PreparedStatement) ConexionMySQL.getInstancia().getConexion().prepareStatement("select * from mesa");
            rs = ps.executeQuery();
            while(rs.next())
            {
                int nroMesa = Integer.valueOf(rs.getString("idMesa"));
                mesas.add(new Mesa(nroMesa));
            }            
        }
        catch (Exception e) 
        {
            System.out.println("Error in getData" + e);
        }
        return mesas;
    }

    @Override
    public ArrayList<Mozo> getListaMozos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Mozo> mozos = new ArrayList<Mozo>();
        try
        {
            ps = (PreparedStatement) ConexionMySQL.getInstancia().getConexion().prepareStatement("select * from mozo");
            rs = ps.executeQuery();
            while(rs.next())
            {
                int id = Integer.valueOf(rs.getString("mozoID"));
                String nombre= rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = Integer.valueOf(rs.getString("DNI"));
                mozos.add(new Mozo(id,nombre,apellido,dni));
            }            
        }
        catch (Exception e) 
        {
            System.out.println("Error in getData" + e);
        }
        return mozos;
    }

    @Override
    public ArrayList<Producto> getListaProductos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            ps = (PreparedStatement) ConexionMySQL.getInstancia().getConexion().prepareStatement("select * from producto");

            rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = Integer.valueOf(rs.getString("ProductoID"));
                String descripcion = rs.getString("Descproducto");
                double precio = Double.valueOf(rs.getString("precioUnitario"));
                boolean esAgregado = Boolean.valueOf(rs.getString("esAgregado"));
                
                productos.add(new Producto(idProducto,descripcion,precio,esAgregado));
            }

        } catch (Exception e) {
            System.out.println("Error in getData" + e);
        }
        return productos;
    }

    //@Override
    public void inicializarMesas(int cantidad) {
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
        
    }
    
}
