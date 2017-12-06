/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author Ignacio Alvarez
 */
public interface IRepositorioProductos 
{
    public List<Producto> getTodosProducto();
    public void insert(Producto product);
    public void update(Producto product);
    public void delete(Integer id);
    public Producto select(Integer id);
    
}
