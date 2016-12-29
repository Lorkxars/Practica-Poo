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
    public Producto buscarNombre(String nombre){
        boolean aux = false;
        int i = 0;
        while (i<catalogo.size() && !aux){
            aux = (catalogo.get(i).getNombre() == nombre);
            i = i +1;
        }
        //crear excepcion y si aux igual a false lanzarla y tratarla diciendo que ese objeto no esta
        return catalogo.get(i-1);
    }
}
