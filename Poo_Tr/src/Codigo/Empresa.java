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
    
    /**
     * Constructor que recibe e inicializa todos los atributos de la empresa a valores conocidos de antemano
     * @param nombre nombre de la empresa
     * @param franquicias lista de las franquicias que pertenecen a la empresa
     * @param admin del tipo persona el usuario al que le pertenece la empresa
     */
    public Empresa (String nombre, ArrayList <Franquicia> franquicias, Persona admin){
        this.franquicias =  franquicias;
        this.nombre = nombre;
        this.admin = admin;
    }
    /**
     * Constructor usado para crear una empresa de 0, sin franquicias
     * @param nombre nombre de la empresa
     * @param admin del tipo Persona, la persona a la que le pertenece la empresa
     */
    public Empresa (String nombre, Persona admin){
        this.nombre = nombre;
        franquicias = new ArrayList <Franquicia> ();
        this.admin = admin;
    }       

    /**
     * Recibe una franquicia y la anade a la lista de franquicias de la empresa
     * @param f franquicia a anadir
     */
    public void anadirFranquicia (Franquicia f){
        franquicias.add(f);
    }
    
    /**
     * Comprueba si una franquicia pertenece a la empresa
     * @param f la franquicia a buscar
     * @return devuelve si la ha encontrado o no
     */
    public boolean estaFranquicia (Franquicia f){
        return franquicias.contains(f);
    }
    
    /**
     * Elimina una franquicia de la empresa
     * @param p franquicia a eliminar
     */
    public void eliminaFranquiciar (Franquicia p){
        franquicias.remove(p);
    }
    
    /**
     * Busca una franquicia por el nombre de la misma y, si la encuentra en la lista de franquicias la devuelve
     * @param nombre franquicia de la empresa a buscar
     * @return franquicia en caso de que este en la empresa
     * @throws NoEncontradoExcp en caso de que no se encuentre la franquicia se devolvera esta excepcion
     */
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
    
    /**
     * Devuelve el combinado del catalogo de todas las franquicias en orden por defecto
     * @return catalogo orden por defecto
     */
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
    
    /**
     * Devuelve el combinado del catalogo de todas las franquicias ordenado por el precio de los productos
     * @return catalogo orden precio productos
     */
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
    
    /**
     * Devuelve el combinado del catalogo de todas las franquicias ordenado por el nombre de la franquicia a la que pertenece el producto
     * @return catalogo orden precio productos
     */
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
    
    /**
     * Busca en todas las franquicias  de la empresa a un dueno que se le pasa por usuario y contrasena y si lo encuentra lo devuelve como
     * objeto de la clase Dueno
     * @param usuario   el usuario a buscar
     * @param contrasena    la contrasena correspondiente al usuario a buscar
     * @return el dueno si pertenece a la empresa como dueno
     * @throws NoEncontradoExcp en caso de que el dueno no pertenezca a la empresa como dueno se produce esta excepcion
     */
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
    
    /**
     * Busca en todas las franquicias  de la empresa a un empleado que se le pasa por usuario y contrasena y si lo encuentra lo devuelve como
     * objeto de la clase Empleado
     * @param usuario   el usuario a buscar
     * @param contrasena    la contrasena correspondiente al usuario a buscar
     * @return el empleado si pertenece a la empresa como empleado
     * @throws NoEncontradoExcp en caso de que el empleado no pertenezca a la empresa como empleado se produce esta excepcion
     */
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




























