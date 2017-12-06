/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Alvarez
 */
public class TestLineaPedido {
    
    public TestLineaPedido() {
    }

    @Test
    public void calcularTotal()
    {
        Producto p1 = new Producto(0, "milanesa", 50, false);
        
        LineaPedido lineaPedido = new LineaPedido(p1, 2);
        
        assertEquals(100, lineaPedido.getTotal() ,0.05);
    }
    
    @Test
    public void calcularTotal1()
    {
        Producto p1 = new Producto(0, "milanesa", 50, false);
        Producto agregado1 = new Producto(0, "agregado1", 15, true);
        Producto agregado2 = new Producto(0, "agregado2", 15, true);
        p1.agregarAgregado(agregado2);
        p1.agregarAgregado(agregado1);
        
        LineaPedido lineaPedido = new LineaPedido(p1, 2);
        
        assertEquals(160, lineaPedido.getTotal() ,0.05);
    }
    
    @Test
    public void calcularTotal2()
    {
        Producto p1 = new Producto(0, "milanesa", 50, false);
        
        p1.agregarAgregado(p1);
        
        LineaPedido lineaPedido = new LineaPedido(p1, 2);
        
        assertEquals(100, lineaPedido.getTotal() ,0.05);
    }
    @Test
    public void calcularTotal3()
    {
        Promocion promo = new Promocion(0, "promo1", 0.75);
        Producto producto = new Producto(0, "milanesa", 50, false);
        Producto agregado1 = new Producto(0, "agregado1", 15, true);
        Producto agregado2 = new Producto(0, "agregado2", 15, true);
        producto.agregarAgregado(agregado2);
        producto.agregarAgregado(agregado1);
        promo.agregarProducto(producto);
        
        
        LineaPedido lineaPedido = new LineaPedido(promo, 2);
        
        assertEquals(120, lineaPedido.getTotal() ,0.05);
    }
    @Test
    public void calcularTotal4()
    {
        Promocion promo = new Promocion(0, "promo1", 0.75);
        promo.agregarProducto(null);
        
        LineaPedido lineaPedido = new LineaPedido(promo, 2);
        
        assertEquals(0, lineaPedido.getTotal() ,0.05);
    }
    @Test
    public void calcularTotal5()
    {
        
        LineaPedido lineaPedido = new LineaPedido(null, 2);
        
        assertEquals(0, lineaPedido.getTotal() ,0.05);
    }
    @Test
    public void calcularTotal6()
    {
        Producto p1 = new Producto(0, "milanesa", 50, false);
        Producto agregado1 = new Producto(0, "agregado1", 15, true);
        Producto agregado2 = new Producto(0, "agregado2", 15, true);
        p1.agregarAgregado(agregado2);
        p1.agregarAgregado(agregado1);
        
        LineaPedido lineaPedido = new LineaPedido(p1, 0);
        
        assertEquals(0, lineaPedido.getTotal() ,0.05);
    }
    
}
