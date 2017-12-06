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
 * @author maria
 */
public interface Negocio {

    Mesa buscarMesa(int numero);

    Mozo buscarMozo(int numero);

    Producto buscarProducto(int id);

    ArrayList<Producto> filtrarCatalogo(String filtro);

    ArrayList<Mesa> getListaMesas();

    ArrayList<Mozo> getListaMozos();

    ArrayList<Producto> getListaProductos();

    void inicializarMesas(int cantidad);
    
}
