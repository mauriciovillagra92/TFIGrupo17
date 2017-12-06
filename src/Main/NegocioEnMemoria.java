/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Modelo.Mesa;
import Modelo.Mozo;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author Ignacio Alvarez
 */
public class NegocioEnMemoria implements Negocio 
{
    private ArrayList<Mesa> listaMesas;
    private ArrayList<Mozo> listaMozos;
    private ArrayList<Producto> listaProductos;
    
    public NegocioEnMemoria()
    {
        listaMesas = new ArrayList<>();
        listaMozos = new  ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    @Override
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    
    @Override
    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    @Override
    public ArrayList<Mozo> getListaMozos() {
        return listaMozos;
    }

    public void agregarProducto(Producto p)
    {
        listaProductos.add(p);
    }
    
    @Override
    public void inicializarMesas(int cantidad)
    {
        for(int i = 1; i<=cantidad;i++)
        {
            agregarMesa(new Mesa(i));
        }
    }

    public void agregarMesa(Mesa m) 
    {
        listaMesas.add(m);
    }

    public void agregarMozo(Mozo m)
    {
        listaMozos.add(m);
    }
    
    @Override
    public Mesa buscarMesa(int numero)
    {
        for(Mesa m: listaMesas)
        {
            if(m.getNumero() == numero)
                return m;
        }
        return null;
    }
    @Override
    public Mozo buscarMozo(int numero)
    {
        for(Mozo m: listaMozos)
        {
            if(m.getId() == numero)
                return m;
        }
        return null;
    }
    @Override
    public Producto buscarProducto(int id)
    {
        for(Producto p: listaProductos)
        {
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    @Override
    public ArrayList<Producto> filtrarCatalogo(String filtro)
    {
        ArrayList<Producto> listaAuxiliar = new ArrayList<>();
        
        for(Producto p: listaProductos)
        {
            if(p.getDescripcion().contains(filtro))
                listaAuxiliar.add(p);
        }
        
        
        return listaAuxiliar;
    }

}
