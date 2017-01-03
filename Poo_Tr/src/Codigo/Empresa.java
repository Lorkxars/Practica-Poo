/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author david
 */
public class Empresa {
    private String nombre;
    private ArrayList <Franquicia> franquicias;
    
    public Empresa (String nombre, ArrayList <Franquicia> franquicias){
        this.franquicias =  franquicias;
        this.nombre = nombre;
    }
    public Empresa (String nombre){
        this.nombre = nombre;
        franquicias = new ArrayList <Franquicia> ();
    }       
            
    public void anadirFranquicia (Franquicia f){
        franquicias.add(f);
    }
    public boolean estaFranquicia (Franquicia f){
        return franquicias.contains(f);
    }
    public void eliminaFranquiciar (Franquicia p){
        franquicias.remove(p);
    }
    
    public Franquicia buscarNombre(String nombre) throws NoEncontradoExcp{
        boolean aux = false;
        int i = 0;
        while (i<franquicias.size() && !aux){
            aux = (franquicias.get(i).getNombre().equalsIgnoreCase(nombre));
            i = i +1;
        }
        if (!aux){
            throw new NoEncontradoExcp("La franquicia buscada no pertenece a la empresa");
        }
        return franquicias.get(i-1);
    }
    //Devuelve el catalogo por ordenes de inserccion
    public Catalogo superCatalogo(){
        Catalogo aux = new Catalogo();
        for(int i=0; i < franquicias.size(); i++){
            Franquicia faux = franquicias.get(i);
            for(int j=0; j < faux.getCatalogo().size(); j++){
                Producto p = faux.getCatalogo().getProducto(j);
                aux.anadirProducto(p);
            }
        }
        return aux;
    }
    
    //Ordenado por precio de los productos (En teoria al menos)
    public Catalogo superCatalogoP(){
        Catalogo aux = new Catalogo();
        for(int i=0; i < franquicias.size(); i++){
            Franquicia faux = franquicias.get(i);
            for(int j=0; j < faux.getCatalogo().size(); j++){
                Producto p = faux.getCatalogo().getProducto(j);
                aux.anadirProducto(p);
            }
        }
        Collections.sort(aux.getCatalogo());
        return aux;
    }
    
    //Y ordenado por el nombre de la franquicia a la que pertenecen
    public Catalogo superCatalogoN(){
         Catalogo aux = new Catalogo();
         ArrayList <Franquicia> intermediario = franquicias;//Sacamos una copia de la lista de franquicias y la ordenamos
         Collections.sort(intermediario);
        for(int i=0; i < intermediario.size(); i++){
            Franquicia faux = intermediario.get(i);
            for(int j=0; j < faux.getCatalogo().size(); j++){
                Producto p = faux.getCatalogo().getProducto(j);
                aux.anadirProducto(p);
            }
        }
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Franquicia> getFranquicias() {
        return franquicias;
    }
    
}




























