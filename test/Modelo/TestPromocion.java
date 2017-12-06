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
public class TestPromocion {
    
    public TestPromocion() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void calcularTotal()
    {
        Promocion promo = new Promocion(1, "Promo 1", 1);
        
        promo.agregarProducto(new Producto(1, "Milanesa", 50, false));
        promo.agregarProducto(new Producto(2, "Milanesa", 50, false));
        
        assertEquals(100,promo.calcularPrecio(),0.05);
    }
    
    @Test
    public void calcularTotal2()
    {
        Promocion promo = new Promocion(1, "Promo 1", 1);
        Producto producto = new Producto(1, "Milanesa", 50, false);
        Producto agregado = new Producto(1, "Huevo", 15, true);
        producto.agregarAgregado(agregado);
        
        promo.agregarProducto(producto);
        
        assertEquals(65,promo.calcularPrecio(),0.05);
    }
    @Test
    public void calcularTotal3()
    {
        Promocion promo = new Promocion(1, "Promo 1", 0.5);
        
        promo.agregarProducto(new Producto(1, "Milanesa", 50, false));
        promo.agregarProducto(new Producto(2, "Milanesa", 50, false));
        
        assertEquals(50,promo.calcularPrecio(),0.05);
    }
    @Test
    public void calcularTotal4()
    {
        Promocion promo = new Promocion(1, "Promo 1", 0.5);
        Producto producto = new Producto(1, "Milanesa", 50, false);
        Producto agregado = new Producto(1, "Huevo", 20, true);
        producto.agregarAgregado(agregado);
        
        promo.agregarProducto(producto);
        
        assertEquals(35,promo.calcularPrecio(),0.05);
    }
    
    @Test
    public void calcularTotal5()
    {
        Promocion promo = new Promocion(1, "Promo 1", 1);
        
        promo.agregarProducto(null);
        
////        assertEquals(0,promo.calcularPrecio(),0.05);
    }
}
