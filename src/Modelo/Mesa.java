/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ignacio Alvarez
 */
public class Mesa 
{
    private int numero;
    private boolean estado = false;
    private Pedido pedido;
    
    public Mesa(int numero)
    {
        this.numero = numero;
    }

    public void iniciarMesa()
    {
        if(this != null)
        {
            estado = true;
            this.pedido = new Pedido(this);
        }
        
    }
    public double cerrarMesa()
    {
        estado = false;
        return pedido.getTotal();
    }
    public void agregarLineaPedido(Producto p, int cantidad)
    {
        pedido.agregarLineaPedido(p,cantidad);
    }
   
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }
    
    public double calcularTotal()
    {
        return pedido.getTotal();
    }
    
    
}
