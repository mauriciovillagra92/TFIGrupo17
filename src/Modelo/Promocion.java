/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author 17
 */
public class Promocion extends Bien
{
    private double descuento;
    private ArrayList<Producto> listaProductos;

    public Promocion(int id, String descripcion, double descuento) {
        super(id, descripcion);
        this.descuento = descuento;
        listaProductos = new ArrayList<>();
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public double calcularPrecio()
    {
        double total = 0;
        for(Producto p: listaProductos)
        {
            total += p.calcularPrecio();
        }
        return total * descuento;
    }

    public void agregarProducto(Producto p)
    {
        if((p != null) && (p.isEsAgregado() == false))
            this.listaProductos.add(p);
    }
    
}
