/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 17
 */
public class Pedido 
{
    private Mozo mozo;
    private Mesa mesa;
    private ArrayList<LineaPedido> listaLineaPedido;
    private Date fecha;
    private String estado;
    public Pedido(Mozo mozo, Mesa mesa) 
    {
        this.mozo = mozo;
        this.mesa = mesa;
        listaLineaPedido = new ArrayList<>();
        fecha = new Date();
    }
    public Pedido(Mesa mesa)
    {
        this.mesa = mesa;
        listaLineaPedido = new ArrayList<>();
        fecha = new Date();
    }

        public double getTotal()
    {
        double total = 0;
        for(LineaPedido p: listaLineaPedido)
        {
            total += p.getTotal();
        }
        return total;
    }
    public void agregarLineaPedido(LineaPedido lp)
    {
        if(lp!=null)
            listaLineaPedido.add(lp);
    }
    public void agregarLineaPedido(Producto p, int cantidad)
    {
        if(p!=null)
            listaLineaPedido.add(new LineaPedido(p, cantidad));
    }
    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<LineaPedido> getListaProductos() {
        return listaLineaPedido;
    }

    public void setListaProductos(ArrayList<LineaPedido> listaProductos) {
        this.listaLineaPedido = listaProductos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}


