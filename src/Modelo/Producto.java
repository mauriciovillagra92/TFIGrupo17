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
public class Producto extends Bien
{
    private double precio;
    private boolean esAgregado;
    private ArrayList<Producto> listaAgregados;

    public Producto(int id,String descripcion, double precio,boolean esAgregado)
    {
        super(id, descripcion);
        this.precio = precio;
        this.esAgregado = esAgregado;
        listaAgregados = new ArrayList<>();
    }
    
    
    public void agregarAgregado(Producto producto)
    {
        if((producto != null) && producto.isEsAgregado() && !this.isEsAgregado())
            listaAgregados.add(producto);
    }
    
    @Override
    public double calcularPrecio()
    {
        double total = this.precio;
        for(Producto agregado: listaAgregados)
        {
            total += agregado.calcularPrecio();
        }
        return total;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean isEsAgregado() {
        return esAgregado;
    }
    public void setEsAgregado(boolean esAgregado) {
        this.esAgregado = esAgregado;
    }

    public ArrayList<Producto> getListaAgregados() {
        return listaAgregados;
    }

    public void setListaAgregados(ArrayList<Producto> listaAgregados) {
        this.listaAgregados = listaAgregados;
    }
    
 
}
