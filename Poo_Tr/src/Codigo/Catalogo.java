/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class Catalogo {
    private ArrayList <Producto> catalogo;
    
    public Catalogo (){
        catalogo = new ArrayList <Producto> ();
    }
    public void anadirProducto (Producto p){
        catalogo.add(p);
    }
    public boolean esta (Producto p){
        return catalogo.contains(p);
    }
    public void eliminar (Producto p){
        catalogo.remove(p);
    }
    public Producto buscarNombre(String nombre) throws NoEncontradoExcp{
        boolean aux = false;
        int i = 0;
        while (i<catalogo.size() && !aux){
            aux = (catalogo.get(i).getNombre().equalsIgnoreCase(nombre));
            i = i +1;
        }
        if (!aux){
            throw new NoEncontradoExcp("El objeto buscado no se encuentra en el catalogo");
        }
        return catalogo.get(i-1);
    }
}
