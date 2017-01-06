/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

/**
 *
 * @author david
 */
public class Empresa implements Serializable{
    private String nombre;
    private ArrayList <Franquicia> franquicias;
    private Persona admin;
    
    public Empresa (String nombre, ArrayList <Franquicia> franquicias, Persona admin){
        this.franquicias =  franquicias;
        this.nombre = nombre;
        this.admin = admin;
    }
    public Empresa (String nombre, Persona admin){
        this.nombre = nombre;
        franquicias = new ArrayList <Franquicia> ();
        this.admin = admin;
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

    public Persona getAdmin() {
        return admin;
    }
    public Dueno esDueno(String usuario, String contrasena) throws NoEncontradoExcp{//devuelve el dueno si esta y si no produce excepcion
        int i = 0;
        boolean encontrado = false;
        do{
            encontrado = (usuario.equals(this.franquicias.get(i).getDueno().getUsuario()) && (contrasena.hashCode() == this.franquicias.get(i).getDueno().getPassword()));
            i++;
        }while(i < this.getFranquicias().size() && !encontrado);
        if(encontrado){
            return this.getFranquicias().get(i-1).getDueno();
        }
        else{
            throw new NoEncontradoExcp("Este usuario no pertenece a un Dueno");
        }
    }
    
    public Empleado esEmpleado(String usuario, String contrasena) throws NoEncontradoExcp{
        int i = 0;
        boolean encontrado = false;
        int aux;
        do{
            aux = this.franquicias.get(i).esEmpleado(usuario, contrasena);
            if(aux != -1){
                encontrado = true;
            }            
            i++;
        }while(i < this.getFranquicias().size() && !encontrado);
        if(encontrado){
            return this.franquicias.get(i-1).getEmpleados().get(aux);
        }
        else{
            throw new NoEncontradoExcp("Este usuario no pertenece a un Empleado");
        }
    }
    
    
}




























