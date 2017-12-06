package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Alvarez
 */
public class TestPedido 
{
    
    @Test
    public void getTotal()
    {
        Pedido pedido = new Pedido(new Mozo(0,"nombre", "apellido",000000001), new Mesa(1));
        
        pedido.agregarLineaPedido(null);
        
        assertEquals(0, pedido.getTotal(),0.05);
    }
    
    @Test
    public void getTotal1()
    {
        Pedido pedido = new Pedido(new Mesa(1));
        Promocion promocion = new Promocion(1, "promocion 1", 0.9);
        Producto producto = new Producto(0, "milanesa", 45, false);
        Producto agregado = new Producto(1, "agregado", 5, true);
        producto.agregarAgregado(agregado);
        promocion.agregarProducto(producto);
        LineaPedido lineaPedido = new LineaPedido(promocion, 2);
        
        pedido.agregarLineaPedido(lineaPedido);
        
        assertEquals(90, pedido.getTotal(),0.05);
    }
    @Test
    public void getTotal2()
    {
        Pedido pedido = new Pedido(new Mesa(1));
        Promocion promocion = new Promocion(1, "promocion 1", 1);
        Producto agregado = new Producto(1, "agregado", 5, true);
        promocion.agregarProducto(agregado);
        LineaPedido lineaPedido = new LineaPedido(promocion, 1);
        
        pedido.agregarLineaPedido(lineaPedido);
        
        assertEquals(0, pedido.getTotal(),0.05);
    }
    
    
}
