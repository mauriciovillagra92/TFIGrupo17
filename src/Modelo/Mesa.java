/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Mesa 
{
    private int numero;
    //private Pedido pedido;
    
    public Mesa(int numero)
    {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

 /*   public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }*/

    @Override
    public String toString() {
        return String.valueOf(numero);
    }
   
}
