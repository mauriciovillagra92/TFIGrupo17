/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 17
 */
public class LineaPedido 
{
    private Bien bien;
    private int cantidad;

    public LineaPedido(Bien bien, int cantidad) 
    {
        this.bien = bien;
        this.cantidad = cantidad;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotal()
    {
        if(bien != null)
            return bien.calcularPrecio() * cantidad;
        return 0;
    }
    
    public Bien crearVendible(int id, String descripcion, double precio, boolean esAgregado, double descuento)
    {
        if(descuento == 0)
        {
            return new Producto(id, descripcion, precio, esAgregado);
        }
        if(descuento != 0)
        {
            return new Promocion(id, descripcion, descuento);
        }
        return null;
        
    }
}
