/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Main.Negocio;
import Modelo.Mesa;
import Modelo.Mozo;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class NegocioMySQL implements Negocio {

    @Override
    public Mesa buscarMesa(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mozo buscarMozo(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> filtrarCatalogo(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mesa> getListaMesas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mozo> getListaMozos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> getListaProductos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
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

    @Override
    public void inicializarMesas(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
