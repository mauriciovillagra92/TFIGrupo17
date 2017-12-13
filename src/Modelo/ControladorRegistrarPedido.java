/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Main.Negocio;
import Main.NegocioEnMemoria;
import Vistas.VentanaNuevoPedido;
import java.util.ArrayList;

/**
 *
 * @author Ignacio Alvarez
 */
public class ControladorRegistrarPedido 
{
    private IVentanaPedido ventana;
    private Negocio negocio;
    
    public ControladorRegistrarPedido(Negocio negocio)
    {
        this.negocio = negocio;
    }
    public Object[] cargarComboMozos()
    {
        return negocio.getListaMozos().toArray();
    }
    public Object[] cargarComboMesas()
    {
        return negocio.getListaMesas().toArray();
    }
    
    public void iniciarPedido(int numMesa, int numMozo)
    {
        Mesa mesa = negocio.getMesa(numMesa);
        Mozo mozo = negocio.getMozo(numMozo);
        Pedido pedido = new Pedido(mozo,mesa);
        pedido.setEstado("En curso");  
    }
    public void agregarProducto(Pedido pedido,int codigoProducto,int cantidad)
    {
        Producto p = negocio.buscarProducto(codigoProducto);  
        pedido.agregarLineaPedido(p, cantidad);
    }
    /*public void cargarPedido(Mozo mozo, Mesa mesa, int cantidad, int cantProductos)
    {
        if(mesa.isEstado())
        {
            mesa.getPedido().setMozo(mozo);
            
        }
        
    }*/
    /*public void cargarCatalogo(IVentanaPedido ventana)
    {
        Producto p = negocio.buscarProducto(codigoProducto);
        Mesa m = negocio.buscarMesa(numeroMesa);
        
        m.agregarLineaPedido(p, cantidad);
    }
    */
    public IVentanaPedido getVentana() {
        return ventana;
    }

    public void setVentana(IVentanaPedido ventana) {
        this.ventana = ventana;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioEnMemoria negocio) {
        this.negocio = negocio;
    }

    public ArrayList<Producto> getProductos() {
        return negocio.getListaProductos();
    }
    
}
