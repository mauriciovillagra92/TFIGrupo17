/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Mesa;
import Modelo.Mozo;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author 17
 */
public interface Negocio {

    Mesa getMesa(int numero);

    Mozo getMozo(int numero);

    Producto buscarProducto(int id);

   // ArrayList<Producto> filtrarCatalogo(String filtro);

    ArrayList<Mesa> getListaMesas();

    ArrayList<Mozo> getListaMozos();

    ArrayList<Producto> getListaProductos();

    //void inicializarMesas(int cantidad);
    
}
