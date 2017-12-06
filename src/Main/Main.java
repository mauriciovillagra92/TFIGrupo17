/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Datos.NegocioMySQL;
import Datos.RepositorioMesaMySql;
import Datos.RepositorioMozoMySql;
import Datos.RepositorioProductosMySql;
import Modelo.ControladorRegistrarPedido;
import Vistas.VentanaPrincipal;

/**
 *
 * @author Ignacio Alvarez
 */
public class Main 
{
    public static void main(String[] arg)
    {
        ControladorRegistrarPedido controlador = new ControladorRegistrarPedido(new NegocioMySQL());
        controlador.getNegocio().inicializarMesas(RepositorioMesaMySql.getInstancia().getCantidadMesa());
        
        RepositorioProductosMySql.getInstancia().getTodosProducto();
        RepositorioMozoMySql.getInstancia().getMozos();
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        
        
    }
}
